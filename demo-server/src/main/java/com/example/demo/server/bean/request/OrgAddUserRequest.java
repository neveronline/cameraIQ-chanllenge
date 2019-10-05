package com.example.demo.server.bean.request;

import lombok.Data;

import java.util.List;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:12:25
 * ------------------------------------
 * Desc:
 */
@Data
public class OrgAddUserRequest {
    private Integer orgId;
    private List<Integer> userIds;
}
