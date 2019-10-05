package com.example.demo.dal.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:01:07
 * ------------------------------------
 * Desc:
 */
@Data
public class OrganizationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String address;

    private String phone;

    private Integer validStatus;

    private Date createTime;

    private Date updateTime;
}
