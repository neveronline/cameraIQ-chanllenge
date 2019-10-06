package com.example.demo.server.service;

import com.example.demo.server.bean.request.OrgAddUserRequest;
import com.example.demo.server.bean.request.UserOrgRelationRequest;

import java.util.List;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:12:00
 * ------------------------------------
 * Desc:
 */
public interface IRelationService {
    List<Integer> queryAllUsersByOrgId(Integer orgId);
    List<Integer> queryAllOrgsByUserId(Integer userId);

    Boolean UserJoinOrgs(UserOrgRelationRequest request);

    Boolean UserLeaveOrg
}
