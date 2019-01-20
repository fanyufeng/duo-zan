package com.duode.model;

/**
 * Created by fanyufeng in 18/12/28
 */
public class AnnexLibrary {
    public int id;
    public int manager_id;
    public int manager_name;
    public String file_name;
    public int category;
    public int choose_status;
    public String file_path;
    public int status;
    public int card_id;
    public String url;
    private String create_time;
    private String modify_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getManager_name() {
        return manager_name;
    }

    public void setManager_name(int manager_name) {
        this.manager_name = manager_name;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getChoose_status() {
        return choose_status;
    }

    public void setChoose_status(int choose_status) {
        this.choose_status = choose_status;
    }

    @Override
    public String toString() {
        return "AnnexLibrary{" +
                "id=" + id +
                ", manager_id=" + manager_id +
                ", manager_name=" + manager_name +
                ", file_name='" + file_name + '\'' +
                ", category=" + category +
                ", choose_status=" + choose_status +
                ", file_path='" + file_path + '\'' +
                ", status=" + status +
                ", card_id=" + card_id +
                ", url='" + url + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
