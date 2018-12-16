package com.duode.model;

/**
 * Created by fanyufeng on 2018/11/29
 */
public class Card {
    public int id;
    public int product_id;
    public int advertise_id;
    public int integration_num;
    public int status;
    public int times;
    public String unique_id;
    public String comment;
    public String create_time;
    public String modify_time;

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

    public int getAdvertise_id() {
        return advertise_id;
    }

    public void setAdvertise_id(int advertiser_id) {
        this.advertise_id = advertiser_id;
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
        return "Card{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", advertiser_id=" + advertise_id +
                ", integration_num=" + integration_num +
                ", status=" + status +
                ", times=" + times +
                ", unique_id='" + unique_id + '\'' +
                ", comment='" + comment + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
