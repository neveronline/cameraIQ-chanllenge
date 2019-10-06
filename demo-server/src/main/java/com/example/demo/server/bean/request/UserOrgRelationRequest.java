package com.example.demo.server.bean.request;

import lombok.Data;
import org.springframework.util.CollectionUtils;

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
public class UserOrgRelationRequest {
    private Integer userId;
    private List<Integer> orgIds;
    private Integer relation;

    public boolean isValid(){
        return userId != null && userId > 0 && !CollectionUtils.isEmpty(orgIds);
    }
}
