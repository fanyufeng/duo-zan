package com.duode.model;

/**
 * Created by fanyufeng in 19/1/21
 */
public class File {
    public int id;
    public String name;
    public int status;
    public String comment;
    public int advertiser_id;
    public String file_imgUrl;
    public String file_videoUrl;
    public String link;
    public int frequency;
    public int imOrVi;
    public int category;
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

    public int getAdvertiser_id() {
        return advertiser_id;
    }

    public void setAdvertiser_id(int advertiser_id) {
        this.advertiser_id = advertiser_id;
    }

    public String getFile_imgUrl() {
        return file_imgUrl;
    }

    public void setFile_imgUrl(String file_imgUrl) {
        this.file_imgUrl = file_imgUrl;
    }

    public String getFile_videoUrl() {
        return file_videoUrl;
    }

    public void setFile_videoUrl(String file_videoUrl) {
        this.file_videoUrl = file_videoUrl;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
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

    public int getImOrVi() {
        return imOrVi;
    }

    public void setImOrVi(int imOrVi) {
        this.imOrVi = imOrVi;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", advertiser_id=" + advertiser_id +
                ", file_imgUrl='" + file_imgUrl + '\'' +
                ", file_videoUrl='" + file_videoUrl + '\'' +
                ", link='" + link + '\'' +
                ", frequency=" + frequency +
                ", imOrVi=" + imOrVi +
                ", category=" + category +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
