package com.duode.model;

/**
 * Created by fanyufeng in 18/12/16
 */
public class Advertise {
    public int id;
    public String name;
    public int advertiser_id;
    public String comment;
    public int status;
    public String advertise_url;
    public String create_time;
    public String modify_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(int advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAdvertise_url() {
        return advertise_url;
    }

    public void setAdvertise_url(String advertise_url) {
        this.advertise_url = advertise_url;
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
        return "Advertise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", advertiser_id=" + advertiser_id +
                ", comment='" + comment + '\'' +
                ", status=" + status +
                ", advertise_url='" + advertise_url + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
