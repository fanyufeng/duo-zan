package com.duode.model;

/**
 * Created by fanyufeng in 18/12/23
 */
public class Manager {
    public int id;
    public String name;
    public String telephone;
    public String password;
    public int status;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", create_time='" + create_time + '\'' +
                ", modify_time='" + modify_time + '\'' +
                '}';
    }
}
