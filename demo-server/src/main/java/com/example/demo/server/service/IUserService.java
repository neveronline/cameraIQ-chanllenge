package com.example.demo.server.service;

import com.example.demo.server.bean.vo.UserInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:11:58
 * ------------------------------------
 * Desc:
 */
public interface IUserService {
    Boolean createUser(UserInfoVO userInfoVO);
    Boolean deleteUser(Integer userId);
    Boolean updateUser(UserInfoVO userInfoVO);
    List<UserInfoVO> getUsersByIds(List<Integer> ids);
}
