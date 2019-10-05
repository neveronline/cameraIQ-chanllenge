package com.example.demo.dal.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrganizationDOMapper {
    String ALL_FIELDS = " id, name, address, phone, valid_status, create_time, update_time ";

}