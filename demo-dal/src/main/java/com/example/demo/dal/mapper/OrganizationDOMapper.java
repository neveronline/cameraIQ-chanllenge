package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.OrganizationDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:01:20
 * ------------------------------------
 * Desc:
 */
public interface OrganizationDOMapper {
    String ALL_FIELDS = " id, name, address, phone, valid_status, create_time, update_time ";

    @Select(
            "select" + ALL_FIELDS + "from organization where id = #{id} and valid_status = 1"
    )
    OrganizationDO queryById(Integer id);

    @Select({
            "<script>",
            "select" + ALL_FIELDS + "from organization where id in ",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach> ",
            " and valid_status = 1",
            "</script>"
    })
    List<OrganizationDO> batchQueryByIds(List<Integer> ids);

    @Insert(
            "insert into organization (name, address, phone, valid_status) " +
                    "values (#{name}, #{address}, #{phone}, #{validStatus})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Boolean insert(OrganizationDO organizationDO);

    @Update({
            "update organization set",
            "<if test= 'name!=null'>",
            "name =#{name}",
            "</if>",
            "<if test= 'address!=null'>",
            ",address =#{address}",
            "</if>",
            "<if test= 'phone!=null'>",
            ",phone =#{phone}",
            "</if>",
            "<if test= 'validStatus!=null'>",
            ",valid_status =#{validStatus}",
            "</if>",
            " where id = #{id}",
            "</script>"
    })
    Boolean update(OrganizationDO organizationDO);
}