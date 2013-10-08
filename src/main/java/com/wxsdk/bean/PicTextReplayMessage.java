package com.wxsdk.bean;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-5-3
 * Time: 下午10:22
 * To change this template use File | Settings | File Templates.
 */
public class PicTextReplayMessage extends Message {

    private long articleCount; // 文章个数

    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public long getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(long articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String getXML() {
        Document document = DocumentHelper.createDocument();
        Element xmlEle = document.addElement("xml");
        super.loadBasicXmlInfos(xmlEle);
        Element articleCountEle = xmlEle.addElement("ArticleCount");
        articleCountEle.setText(String.valueOf(this.getArticleCount()));
        Element articlesEle = xmlEle.addElement("Articles");
        // 明细
        Element itemEle = null;
        for (Article article : this.getArticles()) {
            itemEle = articlesEle.addElement("item");
            article.loadXmlFromArticle(itemEle);
        }
        Element funcFlagEle = xmlEle.addElement("FuncFlag");
        funcFlagEle.setText(String.valueOf(this.getFuncFlag()));
        return document.asXML();
    }
}
