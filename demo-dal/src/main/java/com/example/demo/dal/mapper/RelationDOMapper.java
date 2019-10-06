package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.RelationDO;
import com.example.demo.dal.bean.request.RelationRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    @Select({
            "<script>",
            "select" + ALL_FIELDS + "from user_organization where organization_id = #{orgId} and valid_status = 1",
            "</script>"
    })
    List<RelationDO> queryByOrgId(Integer orgId);
    @Select({
            "<script>",
            "select" + ALL_FIELDS + "from user_organization where user_id = #{userId} and valid_status = 1",
            "</script>"
    })
    List<RelationDO> queryByUserId(Integer userId);

    @Select({
            "<script>",
            "select" + ALL_FIELDS + "from user_organization where user_id = #{userId} and organization_id = #{orgId} and valid_status = 1",
            "</script>"
    })
    RelationDO queryRelation(RelationRequest relationRequest);

    @Insert({
            "<script>",
            "insert into user_organization (user_id, organization_id, valid_status) ",
            "values (#{userId}, #{organizationId}, #{validStatus} )",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Boolean insertRelation(RelationDO relationDO);

    @Update({
            "<script>",
            "update user_organization",
            "<if test= 'userId!=null'>",
            "user_id =#{userId}",
            "</if>",
            "<if test= 'organizationId!=null'>",
            ",organization_id =#{organizationId}",
            "</if>",
            "<if test= 'validStatus!=null'>",
            ",valid_status =#{validStatus}",
            "</if>",
            " where id = #{id}",
            "</script>"
    })
    Boolean updateRelation(RelationDO relationDO);

}
