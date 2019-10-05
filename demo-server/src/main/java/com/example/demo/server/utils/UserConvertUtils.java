package com.example.demo.server.utils;

import com.example.demo.dal.bean.UserDO;
import com.example.demo.server.bean.vo.UserInfoVO;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:19:25
 * ------------------------------------
 * Desc:
 */
public class UserConvertUtils {
    public static UserDO convertToDO(UserInfoVO infoVO){
        if(infoVO == null){
            return null;
        }
        UserDO userDO = new UserDO();
        if(infoVO.getId() != null && !infoVO.getId().equals(0)){
            userDO.setId(infoVO.getId());
        }
        userDO.setFirstName(infoVO.getFirstName());
        userDO.setMiddleName(infoVO.getMiddleName());
        userDO.setLastName(infoVO.getLastName());
        userDO.setEmail(infoVO.getEmail());
        userDO.setAddress(infoVO.getAddress());
        userDO.setPhone(infoVO.getPhone());
        return userDO;
    }
    public static UserInfoVO convertToVO(UserDO userDO){
        if(userDO == null){
            return null;
        }
        UserInfoVO infoVO = new UserInfoVO();
        infoVO.setId(userDO.getId());
        infoVO.setFirstName(userDO.getFirstName());
        infoVO.setMiddleName(userDO.getMiddleName());
        infoVO.setLastName(userDO.getLastName());
        infoVO.setEmail(userDO.getEmail());
        infoVO.setAddress(userDO.getAddress());
        infoVO.setPhone(userDO.getPhone());
        return infoVO;
    }
    private UserConvertUtils(){}
}
