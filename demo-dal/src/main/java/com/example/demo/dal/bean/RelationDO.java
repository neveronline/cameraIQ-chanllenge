package com.example.demo.dal.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:01:14
 * ------------------------------------
 * Desc:
 */
@Data
public class RelationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer organizationId;

    private Integer validStatus;

    private Date createTime;

    private Date updateTime;
}
