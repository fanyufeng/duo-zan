package com.duode.model;

/**
 * Created by fanyufeng in 18/12/28
 */
public class Product {
    public int id;
    public String name;
    public int status;
    public String comment;
    public int factory_id;
    public int card_num;
    public int integration_num;
    private String create_time;
    private String modify_time;

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

    public int getFactory_id() {
        return factory_id;
    }

    public void setFactory_id(int factory_id) {
        this.factory_id = factory_id;
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

    public int getCard_num() {
        return card_num;
    }

    public void setCard_num(int card_num) {
        this.card_num = card_num;
    }

    public int getIntegration_num() {
        return integration_num;
    }

    public void setIntegration_num(int integration_num) {
        this.integration_num = integration_num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", factory_id=" + factory_id +
                ", card_num=" + card_num +
                ", integration_num=" + integration_num +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
