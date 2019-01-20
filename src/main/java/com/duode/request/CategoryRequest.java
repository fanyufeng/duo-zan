package com.duode.request;

import java.util.List;

/**
 * Created by fanyufeng in 19/1/20
 */
public class CategoryRequest {
    public int category;
    public List<Integer> categoryList;

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public List<Integer> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Integer> categoryList) {
        this.categoryList = categoryList;
    }
}
