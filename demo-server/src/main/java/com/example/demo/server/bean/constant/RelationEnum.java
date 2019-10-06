package com.example.demo.server.bean.constant;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-06
 * Time:09:25
 * ------------------------------------
 * Desc:
 */
public enum RelationEnum {
    JOIN(1, "join an org"),
    LEAVE(2, "leave an org");

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

    RelationEnum(int type, String desc) {
        this.code = type;
        this.desc = desc;
    }
}
