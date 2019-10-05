package com.example.demo.server.service.impl;

import com.example.demo.dal.mapper.RelationDOMapper;
import com.example.demo.server.bean.request.OrgAddUserRequest;
import com.example.demo.server.bean.request.UserJoinOrgRequest;
import com.example.demo.server.service.IRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:12:03
 * ------------------------------------
 * Desc:
 */
@Service
public class RelationServiceImpl implements IRelationService {
    @Resource
    RelationDOMapper relationDOMapper;

    @Override
    public List<Integer> queryAllUsersByOrgId(Integer orgId) {
        return null;
    }

    @Override
    public List<Integer> queryAllOrgsByUserId(Integer userId) {
        return null;
    }

    @Override
    public Boolean UserJoinOrgs(UserJoinOrgRequest request) {
        return null;
    }

    @Override
    public Boolean OrgAddUsers(OrgAddUserRequest request) {
        return null;
    }
}
