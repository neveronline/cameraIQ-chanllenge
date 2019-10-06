package com.example.demo.server.utils;

import com.example.demo.dal.bean.OrganizationDO;
import com.example.demo.server.bean.vo.OrgInfoVO;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:19:57
 * ------------------------------------
 * Desc:
 */
public class OrgConvertUtils {
    private OrgConvertUtils(){}
    public static OrganizationDO convertToDO(OrgInfoVO infoVO){
        if(infoVO == null){
            return null;
        }
        OrganizationDO organizationDO = new OrganizationDO();
        if(infoVO.getId() != null && infoVO.getId() > 0){
            organizationDO.setId(infoVO.getId());
        }
        organizationDO.setName(infoVO.getName());
        organizationDO.setAddress(infoVO.getAddress());
        organizationDO.setPhone(infoVO.getPhone());
        return organizationDO;
    }
    public static OrgInfoVO convertToVO(OrganizationDO organizationDO){
        if(organizationDO == null){
            return null;
        }
        OrgInfoVO infoVO = new OrgInfoVO();
        infoVO.setId(organizationDO.getId());
        infoVO.setName(organizationDO.getName());
        infoVO.setAddress(organizationDO.getAddress());
        infoVO.setPhone(organizationDO.getPhone());
        return infoVO;
    }
}
