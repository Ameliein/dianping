package com.graduation.cn.college.dianping.request;

import javax.validation.constraints.NotBlank;

public class SellerCreateReq {
    @NotBlank(message = "Business name can't be null")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
