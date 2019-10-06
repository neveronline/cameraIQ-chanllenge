package com.example.demo.server.biz;

import com.example.demo.server.bean.request.UserOrgRelationRequest;
import com.example.demo.server.bean.vo.OrgInfoVO;
import com.example.demo.server.bean.vo.UserInfoVO;
import com.example.demo.server.service.IOrgService;
import com.example.demo.server.service.IRelationService;
import com.example.demo.server.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-06
 * Time:15:40
 * ------------------------------------
 * Desc:
 */
@Service
public class OperationBiz {
    @Resource
    IOrgService orgService;
    @Resource
    IRelationService relationService;
    @Resource
    IUserService userService;

    public Boolean createOrg(OrgInfoVO orgInfoVO) {
        if(orgInfoVO == null){
            return false;
        }
        return orgService.createOrg(orgInfoVO);
    }

    public Boolean createUser(UserInfoVO userInfoVO) {
        if(userInfoVO == null){
            return false;
        }
        return userService.createUser(userInfoVO);
    }

    public Boolean joinOrgs(UserOrgRelationRequest request) {
        if(request == null || !request.isValid()){
            return false;
        }
        return relationService.UserJoinOrgs(request);
    }

    public Boolean leaveOrgs(UserOrgRelationRequest request) {
        if(request == null || !request.isValid()){
            return false;
        }
        return relationService.UserLeaveOrg(request);
    }

    public List<UserInfoVO> getAllUsersByOrgId(Integer orgId) {
        if(orgId == null || orgId <= 0){
            return Collections.EMPTY_LIST;
        }
        List<Integer> userIdList = relationService.queryAllUsersByOrgId(orgId);
        return userService.getUsersByIds(userIdList);
    }

    public List<OrgInfoVO> getAllOrgsByUserId(Integer userId) {
        if(userId == null || userId <= 0){
            return Collections.EMPTY_LIST;
        }
        List<Integer> orgIdList = relationService.queryAllOrgsByUserId(userId);
        return orgService.getOrgsByIds(orgIdList);
    }
}
