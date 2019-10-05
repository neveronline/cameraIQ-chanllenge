package com.example.demo.server.bean.vo;

import lombok.Data;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:12:06
 * ------------------------------------
 * Desc:
 */
@Data
public class UserInfoVO {
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String address;
    private String phone;
}
