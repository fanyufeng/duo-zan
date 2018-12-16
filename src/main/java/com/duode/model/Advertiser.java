package com.duode.model;

/**
 * Created by fanyufeng in 18/12/16
 */
public class Advertiser {
    public int id;
    public String name;
    public String comment;
    public String address;
    public int status;
    public String telephone;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        return "Advertiser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", telephone='" + telephone + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
