package com.example.demo.server.service.impl;

import com.example.demo.dal.bean.OrganizationDO;
import com.example.demo.dal.mapper.OrganizationDOMapper;
import com.example.demo.server.bean.constant.ValidStatusEnum;
import com.example.demo.server.bean.vo.OrgInfoVO;
import com.example.demo.server.service.IOrgService;
import com.example.demo.server.utils.OrgConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Leo
 * Date:2019-10-05
 * Time:11:59
 * ------------------------------------
 * Desc:
 */
@Service
public class OrgServiceImpl implements IOrgService {
    @Resource
    private OrganizationDOMapper orgMapper;


    @Override
    public Boolean createOrg(OrgInfoVO orgInfoVO) {
        if(orgInfoVO == null){
            return false;
        }
        OrganizationDO organizationDO = OrgConvertUtils.convertToDO(orgInfoVO);
        organizationDO.setValidStatus(ValidStatusEnum.VALID.getCode());
        return orgMapper.insert(organizationDO);
    }

    @Override
    public Boolean updateOrg(OrgInfoVO orgInfoVO) {
        if(orgInfoVO == null || orgInfoVO.getId() == null || orgInfoVO.getId() <= 0){
            return false;
        }
        return orgMapper.update(OrgConvertUtils.convertToDO(orgInfoVO));
    }

    @Override
    public Boolean deleteOrg(Integer orgId) {
        if(orgId == null || orgId <= 0){
            return false;
        }
        OrganizationDO organizationDO = orgMapper.queryById(orgId);
        if(organizationDO == null){
            return false;
        }
        organizationDO.setValidStatus(ValidStatusEnum.DELETED.getCode());
        return orgMapper.update(organizationDO);
    }

    @Override
    public List<OrgInfoVO> getOrgsByIds(List<Integer> ids) {
        if(CollectionUtils.isEmpty(ids)){
            return Collections.EMPTY_LIST;
        }
        return orgMapper.batchQueryByIds(ids).stream().map(OrgConvertUtils::convertToVO)
                .collect(Collectors.toList());
    }
}
