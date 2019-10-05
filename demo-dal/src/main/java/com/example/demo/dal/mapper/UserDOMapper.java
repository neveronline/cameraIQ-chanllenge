package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:01:18
 * ------------------------------------
 * Desc:
 */
public interface UserDOMapper {
    String ALL_FIELDS = " id, first_name, middle_name, last_name, email, address, phone, valid_status, create_time, update_time ";

    @Insert({"insert into user (first_name, middle_name, last_name, email, address, phone, valid_status) ",
        "values(#{firstName}, #{middleName}, #{lastName}, #{email}, #{address}, #{phone}, #{validStatus})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Boolean insert(UserDO userDO);


}
