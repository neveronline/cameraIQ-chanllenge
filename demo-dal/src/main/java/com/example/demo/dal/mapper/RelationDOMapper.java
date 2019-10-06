package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.RelationDO;
import com.example.demo.dal.bean.request.RelationRequest;

import java.util.List;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:01:20
 * ------------------------------------
 * Desc:
 */
public interface RelationDOMapper {
    String ALL_FIELDS = " id, user_id, organization_id, valid_status, create_time, update_time ";

    List<RelationDO> queryByOrgId(Integer orgId);

    List<RelationDO> queryByUserId(Integer userId);

    RelationDO queryRelation(RelationRequest relationRequest);

    Boolean insertRelation(RelationDO relationDO);

    Boolean deleteRelation(RelationDO relationDO);

    Boolean updateRelation(RelationDO relationDO);

}
