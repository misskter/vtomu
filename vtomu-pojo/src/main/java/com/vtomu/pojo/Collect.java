package com.vtomu.pojo;

import com.vtomu.pojo.base.CollectBase;

public class Collect extends CollectBase{





    private Article article;

    private User user;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
