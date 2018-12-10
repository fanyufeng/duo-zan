package com.duode.request;

/**
 * Created by fanyufeng on 2018/11/29
 */
public class CardRequest {
    public int id;
    public int product_id;
    public int advertiser_id;
    public int integration_num;
    public int status;
    public int times;
    public String unique_id;
    public String comment;
    public int user_id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(int advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public int getIntegration_num() {
        return integration_num;
    }

    public void setIntegration_num(int integration_num) {
        this.integration_num = integration_num;
    }


    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
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

    @Override
    public String toString() {
        return "CardRequest{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", advertiser_id=" + advertiser_id +
                ", integration_num=" + integration_num +
                ", status=" + status +
                ", times=" + times +
                ", unique_id='" + unique_id + '\'' +
                ", comment='" + comment + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
