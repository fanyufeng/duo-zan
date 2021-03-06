package com.duode.model;

/**
 * Created by fanyufeng in 18/12/28
 */
public class Checkin {
    public int id;
    public int integration_num;
    public int status;
    public String comment;
    public int user_id;
    private String create_time;
    private String modify_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIntegration_num() {
        return integration_num;
    }

    public void setIntegration_num(int integration_num) {
        this.integration_num = integration_num;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "Checkin{" +
                "id=" + id +
                ", integration_num='" + integration_num + '\'' +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", user_id=" + user_id +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
