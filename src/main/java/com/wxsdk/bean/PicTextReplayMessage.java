package com.wxsdk.bean;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;

/**
 *
 * User: free anuo
 * Date: 13-5-3
 * Time: 下午10:22
 * 图文回复消息
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
    /**
     *
     * User: free anuo
     * Date: 13-5-3
     * Time: 下午10:23
     *  明细
     */
    public static class Article extends BaseObject {

        private String title;
        private String description;
        private String picUrl; // 图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80。
        private String url; // 点击图文消息跳转链接

        public void loadXmlFromArticle(Element parent_) {
            Element itemTitleEle = null;
            Element itemDesEle = null;
            Element itemPicUrlEle = null;
            Element itemUrlEle = null;
            itemTitleEle = parent_.addElement("Title");
            itemTitleEle.setText(this.getTitle() == null ? "" : this.getTitle());

            itemDesEle = parent_.addElement("Description");
            itemDesEle.setText(this.getDescription() == null ? "" : this.getDescription());

            itemPicUrlEle = parent_.addElement("PicUrl");
            itemPicUrlEle.setText(this.getPicUrl() == null ? "" : this.getPicUrl());

            itemUrlEle = parent_.addElement("Url");
            itemUrlEle.setText(this.getUrl() == null ? "" : this.getUrl());
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {}
    }



}
