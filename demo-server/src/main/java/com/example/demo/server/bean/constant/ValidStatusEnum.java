package com.example.demo.server.bean.constant;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:19:42
 * ------------------------------------
 * Desc:
 */
public enum ValidStatusEnum {
    VALID(1, "valid"),
    DELETED(2, "deleted");

    private int code;
    private String desc;

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ValidStatusEnum(int type, String desc) {
        this.code = type;
        this.desc = desc;
    }
}
