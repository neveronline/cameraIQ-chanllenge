package com.example.demo.dal.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:01:06
 * ------------------------------------
 * Desc:
 */
@Data
public class UserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String email;

    private String address;

    private String phone;

    private Integer validStatus;

    private Date createTime;

    private Date updateTime;

}
