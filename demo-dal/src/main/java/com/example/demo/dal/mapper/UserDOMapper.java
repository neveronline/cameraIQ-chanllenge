package com.example.demo.dal.mapper;

import com.example.demo.dal.bean.UserDO;
import org.apache.ibatis.annotations.*;

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
        "values (#{firstName}, #{middleName}, #{lastName}, #{email}, #{address}, #{phone}, #{validStatus})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Boolean insert(UserDO userDO);

    @Select({"<script>",
            "select" + ALL_FIELDS + "from user where id = #{id} and valid_status = 1",
            "</script>"})
    UserDO query(@Param("id") Integer id);

    @Select({"<script>",
            "select" + ALL_FIELDS + "from user where id in ",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach> ",
            " and valid_status = 1",
            "</script>"})
    List<UserDO> batchQuery(@Param("ids") List<Integer> ids);

    @Update({
            "<script>",
            "update user",
            "<if test= 'firstName!=null'>",
            "first_name =#{firstName}",
            "</if>",
            "<if test= 'middleName!=null'>",
            ",middle_name =#{middleName}",
            "</if>",
            "<if test= 'lastName!=null'>",
            ",last_name =#{lastName}",
            "</if>",
            "<if test= 'email!=null'>",
            ",email =#{email}",
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
            "<if test= 'createTime!=null'>",
            ",create_time =#{createTime}",
            "</if>",
            " where id = #{id}",
            "</script>"
    })
    Boolean update(UserDO userDO);

}
