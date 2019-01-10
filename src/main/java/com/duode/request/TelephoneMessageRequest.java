package com.duode.request;

/**
 * Created by fanyufeng in 19/1/10
 */
public class TelephoneMessageRequest {
    public int id;
    public String telephone;
    public String code;
    private String create_time;
    private String modify_time;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String
    toString() {
        return "TelephoneMessageRequest{" +
                "id=" + id +
                ", telephone='" + telephone + '\'' +
                ", code='" + code + '\'' +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
