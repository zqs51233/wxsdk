package com.wxsdk.web.filter;

import com.wxsdk.IMessageService;
import com.wxsdk.bean.Message;
import com.wxsdk.util.NetUtil;
import com.wxsdk.util.StringUtil;
import com.wxsdk.util.XmlUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * User: free anuo
 * Date: 13-5-23
 * Time: 上午9:53
 * To change this template use File | Settings | File Templates.
 */
public class WxFilter implements Filter {

    private static final String SIGNATURE = "signature";
    private static final String TIMESTAMP = "timestamp";
    private static final String NONCE = "nonce";
    private static final String ECHOSTR = "echostr";
    private static final String GET_METHOD_NAME = "get";
    IMessageService messageService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(filterConfig
                .getServletContext());
        this.messageService =  ctx.getBean(IMessageService.class);
        if (this.messageService == null) {
            throw new RuntimeException(
                    "messageService is null ,you should implement the ImessageService interface firstly.");
        }
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        response.setContentType("text/xml;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String method = httpServletRequest.getMethod();
        if (GET_METHOD_NAME.equalsIgnoreCase(method)) {
            this.doAuth(httpServletRequest, httpServletResponse);
        } else {
            this.dispose(httpServletRequest, httpServletResponse);
        }
        return;
    }

    private void dispose(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String retXmlStr = null;
        String receivedXmlStr = NetUtil.receiveData(req);
        Message receivedMsg = XmlUtil.parseXML2Bean(receivedXmlStr);
        Message respMsg = messageService.disposeMsg(receivedMsg);
        retXmlStr = XmlUtil.parseBean2Xml(respMsg);
        if (receivedXmlStr != null) {
            this.writeRespStr(resp, retXmlStr, true);
        }
    }

    private void doAuth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String encodedStr = null;
        String token = messageService.getToken();
        String signature = req.getParameter(SIGNATURE);
        String timestamp = req.getParameter(TIMESTAMP);
        String nonce = req.getParameter(NONCE);
        String echostr = req.getParameter(ECHOSTR);
        encodedStr = StringUtil.encode(token, timestamp, nonce);
        if (encodedStr != null && encodedStr.equals(signature)) {
            this.writeRespStr(resp, echostr, true);
        }
    }

    private void writeRespStr(HttpServletResponse resp, String str, boolean isClose) throws IOException {
        PrintWriter printWriter = null;
        try {
            printWriter = resp.getWriter();
            printWriter.print(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null && isClose) {
                try {
                    printWriter.flush();
                    printWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public IMessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(IMessageService messageService) {
        this.messageService = messageService;
    }

    @Override
    public void destroy() {

    }
}
