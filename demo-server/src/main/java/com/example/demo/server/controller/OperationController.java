package com.example.demo.server.controller;

import com.example.demo.server.bean.request.UserOrgRelationRequest;
import com.example.demo.server.bean.response.WebResponse;
import com.example.demo.server.bean.vo.OrgInfoVO;
import com.example.demo.server.bean.vo.UserInfoVO;
import com.example.demo.server.biz.OperationBiz;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-06
 * Time:16:22
 * ------------------------------------
 * Desc:
 */
@RestController
@RequestMapping("/operation")
public class OperationController {
    @Resource
    OperationBiz operationBiz;

    @PostMapping("/user")
    public WebResponse createAnUser(@RequestBody UserInfoVO userInfoVO){
        try{
            if(!userInfoVO.isValid()){
                return WebResponse.getErrorWebResponse("invalid input");
            }
            Boolean result = operationBiz.createUser(userInfoVO);
            if(result){
                return WebResponse.getSuccessWebResponse();
            }
            return WebResponse.getErrorWebResponse();
        } catch (Exception e){
            // error log here
            return WebResponse.getErrorWebResponse();
        }
    }
    @PostMapping("/org")
    public WebResponse createAnOrg(@RequestBody OrgInfoVO orgInfoVO){
        try{
            Boolean result = operationBiz.createOrg(orgInfoVO);
            if(result){
                return WebResponse.getSuccessWebResponse();
            }
            return WebResponse.getErrorWebResponse();
        } catch (Exception e){
            // error log here
            return WebResponse.getErrorWebResponse();
        }
    }

    @PostMapping("/join")
    public WebResponse joinOrgs(@RequestBody UserOrgRelationRequest request){
        try{
            Boolean result = operationBiz.joinOrgs(request);
            if(result){
                return WebResponse.getSuccessWebResponse();
            }
            return WebResponse.getErrorWebResponse();
        } catch (Exception e){
            // error log here
            return WebResponse.getErrorWebResponse();
        }
    }

    @PostMapping("/leave")
    public WebResponse leaveOrgs(@RequestBody UserOrgRelationRequest request){
        try{
            Boolean result = operationBiz.leaveOrgs(request);
            if(result){
                return WebResponse.getSuccessWebResponse();
            }
            return WebResponse.getErrorWebResponse();
        } catch (Exception e){
            // error log here
            return WebResponse.getErrorWebResponse();
        }
    }
    @GetMapping("/users")
    public WebResponse queryUsersByOrg(@RequestParam(value = "orgId") Integer orgId){
        if(orgId == null || orgId <= 0){
            return WebResponse.getErrorWebResponse("invalid input");
        }
        try{
            List<UserInfoVO> result = operationBiz.getAllUsersByOrgId(orgId);
            WebResponse successWebResponse = WebResponse.getSuccessWebResponse();
            successWebResponse.setData(result);
            return successWebResponse;
        } catch (Exception e){
            // error log here
            return WebResponse.getErrorWebResponse();
        }
    }
    @GetMapping("orgs")
    public WebResponse queryOrgsByUser(@RequestParam(value = "userId") Integer userId){
        if(userId == null || userId <= 0){
            return WebResponse.getErrorWebResponse("invalid input");
        }
        try{
            List<OrgInfoVO> result = operationBiz.getAllOrgsByUserId(userId);
            WebResponse successWebResponse = WebResponse.getSuccessWebResponse();
            successWebResponse.setData(result);
            return successWebResponse;
        } catch (Exception e){
            // error log here
            return WebResponse.getErrorWebResponse();
        }
    }
}
