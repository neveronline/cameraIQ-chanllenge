package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author: Leo
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

    @Select({"<script>",
            "select" + ALL_FIELDS + "from user where id = #{id}",
            "</script>"})
    UserDO query(@Param("id") Integer id);

    @Select({"<script>",
            "select" + ALL_FIELDS + "from user where id in ",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach> ",
            "</script>"})
    List<UserDO> batchQuery(@Param("ids") List<Integer> ids);

    UserDO queryUserByEmail(String email);

    Boolean update(UserDO userDO);

}
