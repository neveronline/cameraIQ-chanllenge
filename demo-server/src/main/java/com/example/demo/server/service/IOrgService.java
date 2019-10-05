package com.example.demo.server.service;

import com.example.demo.server.bean.vo.OrgInfoVO;

import java.util.List;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-05
 * Time:12:02
 * ------------------------------------
 * Desc:
 */
public interface IOrgService {
    OrgInfoVO queryOrgByName(String name);
    Boolean createOrg(OrgInfoVO orgInfoVO);
    Boolean updateOrg(OrgInfoVO orgInfoVO);
    Boolean deleteOrg(Integer orgId);
    List<OrgInfoVO> getOrgsByIds(List<Integer> ids);
}
