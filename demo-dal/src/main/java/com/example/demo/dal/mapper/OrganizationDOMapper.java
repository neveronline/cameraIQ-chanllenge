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

    OrganizationDO queryByName(String name);

    OrganizationDO queryById(Integer id);

    List<OrganizationDO> batchQueryByIds(List<Integer> ids);

    Boolean insert(OrganizationDO organizationDO);

    Boolean update(OrganizationDO organizationDO);
}