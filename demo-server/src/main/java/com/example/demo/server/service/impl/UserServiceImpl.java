package com.example.demo.server.service.impl;

import com.example.demo.dal.bean.UserDO;
import com.example.demo.dal.mapper.UserDOMapper;
import com.example.demo.server.bean.constant.ValidStatusEnum;
import com.example.demo.server.bean.vo.UserInfoVO;
import com.example.demo.server.service.IUserService;
import com.example.demo.server.utils.UserConvertUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
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
public class UserServiceImpl implements IUserService {
    @Resource
    UserDOMapper userMapper;

    @Override
    public UserInfoVO queryUserByEmail(String email) {
        UserDO userDO = userMapper.queryUserByEmail(email);
        return UserConvertUtils.convertToVO(userDO);
    }

    @Override
    public Boolean createUser(UserInfoVO userInfoVO) {
        UserDO userDO = UserConvertUtils.convertToDO(userInfoVO);
        userDO.setValidStatus(ValidStatusEnum.VALID.getCode());
        return userMapper.insert(userDO);
    }

    @Override
    public Boolean deleteUser(Integer userId) {
        if(userId == null || userId <= 0){
            return false;
        }

        UserDO result = userMapper.query(userId);
        if(result == null){
            return false;
        }
        result.setValidStatus(ValidStatusEnum.DELETED.getCode());
        return userMapper.update(result);
    }

    @Override
    public Boolean updateUser(UserInfoVO userInfoVO) {
        if(userInfoVO == null || userInfoVO.getId() == null){
            return false;
        }
        UserDO userDO = UserConvertUtils.convertToDO(userInfoVO);
        return userMapper.update(userDO);
    }

    @Override
    public List<UserInfoVO> getUsersByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids)){
            return Collections.EMPTY_LIST;
        }
        List<UserDO> userDOS = userMapper.batchQuery(ids);
        return userDOS.stream().map(UserConvertUtils::convertToVO).collect(Collectors.toList());
    }
}
