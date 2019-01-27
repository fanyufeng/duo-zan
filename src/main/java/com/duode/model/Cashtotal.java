package com.duode.model;

import java.sql.Timestamp;

/**
 * Created by fanyufeng in 18/12/28
 */
public class Cashtotal {
    public int id;
    public double cash_total;
    public String name;
    public String comment;
    public String deadline;
    public int user_id;
    public int status;
    private String create_time;
    private String modify_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCash_total() {
        return cash_total;
    }

    public void setCash_total(double cash_total) {
        this.cash_total = cash_total;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cashtotal{" +
                "id=" + id +
                ", cash_total=" + cash_total +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", deadline='" + deadline + '\'' +
                ", user_id=" + user_id +
                ", status=" + status +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
