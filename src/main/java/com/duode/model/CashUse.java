package com.duode.model;

/**
 * Created by fanyufeng in 18/12/11
 */
public class CashUse {
    public int id;
    public int cash_total_id;
    public double cash_num;
    public int satus;
    public int user_id;
    public String comment;
    public String create_time;
    public String modify_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCash_total_id() {
        return cash_total_id;
    }

    public void setCash_total_id(int cash_total_id) {
        this.cash_total_id = cash_total_id;
    }

    public double getCash_num() {
        return cash_num;
    }

    public void setCash_num(double cash_num) {
        this.cash_num = cash_num;
    }

    public int getSatus() {
        return satus;
    }

    public void setSatus(int satus) {
        this.satus = satus;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "CashUse{" +
                "id=" + id +
                ", cash_total_id=" + cash_total_id +
                ", cash_num=" + cash_num +
                ", satus=" + satus +
                ", user_id=" + user_id +
                ", comment='" + comment + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
