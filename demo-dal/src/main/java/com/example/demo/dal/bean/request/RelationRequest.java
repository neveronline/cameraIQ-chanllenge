package com.example.demo.dal.bean.request;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:20:56
 * ------------------------------------
 * Desc:
 */
@Data
@NoArgsConstructor
public class RelationRequest {
    Integer userId;
    Integer orgId;


    public RelationRequest(Integer userId, Integer orgId){
        this.userId = userId;
        this.orgId = orgId;
    }
    public boolean isValid(){
        return userId != null && orgId != null && userId > 0 && orgId > 0;
    }
}
