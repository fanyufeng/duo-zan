package com.duode.model;

/**
 * Created by fanyufeng on 2018/11/29
 */
public class Integration {
    public int id;
    public int user_id;
    public int integration_elem;
    public String comment;
    public String create_time;
    public String modify_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getIntegration_elem() {
        return integration_elem;
    }

    public void setIntegration_elem(int integration_elem) {
        this.integration_elem = integration_elem;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }


    @Override
    public String toString() {
        return "Integration{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", integration_elem=" + integration_elem +
                ", comment='" + comment + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
