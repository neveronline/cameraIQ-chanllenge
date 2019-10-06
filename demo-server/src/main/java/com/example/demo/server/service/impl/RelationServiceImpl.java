package com.example.demo.server.service.impl;

import com.example.demo.dal.bean.RelationDO;
import com.example.demo.dal.bean.request.RelationRequest;
import com.example.demo.dal.mapper.RelationDOMapper;
import com.example.demo.server.bean.constant.ValidStatusEnum;
import com.example.demo.server.bean.request.UserOrgRelationRequest;
import com.example.demo.server.service.IRelationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<RelationDO> relations = relationDOMapper.queryByOrgId(orgId);
        if(CollectionUtils.isEmpty(relations)){
            return Collections.EMPTY_LIST;
        }
        Set<Integer> userIds = relations.stream().map(relationDO -> {
            if (relationDO.getValidStatus().equals(ValidStatusEnum.DELETED.getCode())) {
                return -1;
            }
            return relationDO.getUserId();
        }).collect(Collectors.toSet());
        if(userIds.contains(-1)){
            userIds.remove(-1);
        }
        return new ArrayList<>(userIds);
    }

    @Override
    public List<Integer> queryAllOrgsByUserId(Integer userId) {
        List<RelationDO> relations = relationDOMapper.queryByUserId(userId);
        if(CollectionUtils.isEmpty(relations)){
            return Collections.EMPTY_LIST;
        }
        Set<Integer> orgIds = relations.stream().map(relationDO -> {
            if (relationDO.getValidStatus().equals(ValidStatusEnum.DELETED.getCode())) {
                return -1;
            }
            return relationDO.getOrganizationId();
        }).collect(Collectors.toSet());
        if(orgIds.contains(-1)){
            orgIds.remove(-1);
        }
        return new ArrayList<>(orgIds);
    }

    @Override
    @Transactional
    public Boolean UserJoinOrgs(UserOrgRelationRequest request) {
        List<RelationRequest> relationRequestList = convertToRelationRequest(request);
        for(RelationRequest relationRequest : relationRequestList){
            RelationDO relationDO = relationDOMapper.queryRelation(relationRequest);
            if(relationDO == null) {
                relationDO = convertRequestToDO(relationRequest);
            }
            relationDO.setValidStatus(ValidStatusEnum.VALID.getCode());
            relationDOMapper.insertRelation(relationDO);
        }
        return true;
    }

    private List<RelationRequest> convertToRelationRequest(UserOrgRelationRequest request){
        if(request == null || !request.isValid()){
            return Collections.EMPTY_LIST;
        }
        return request.getOrgIds().stream().map(orgId->{
            if(orgId == null || orgId <= 0){
                return new RelationRequest();
            }
            return new RelationRequest(request.getUserId(), orgId);
        }).collect(Collectors.toList());
    }

    private RelationDO convertRequestToDO(RelationRequest request){
        if(request == null || !request.isValid()){
            return null;
        }
        RelationDO relationDO = new RelationDO();
        relationDO.setUserId(request.getUserId());
        relationDO.setOrganizationId(request.getOrgId());
        return relationDO;
    }


}
