package com.tien.amall.product.service.impl;


import com.tien.amall.product.entity.AttrEntity;
import com.tien.amall.product.service.AttrService;
import com.tien.amall.product.vo.AttrGroupWithAttrsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tien.common.utils.PageUtils;
import com.tien.common.utils.Query;

import com.tien.amall.product.dao.AttrGroupDao;
import com.tien.amall.product.entity.AttrGroupEntity;
import com.tien.amall.product.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    AttrService attrService;

    /**
     * @Author: Acme Tien
     * @Date: 2022/5/6 14:58
     * @Email: bhappy1314i@gmail.com
     * @Params: [catelogId]
     * @return: java.util.List<com.tien.amall.product.vo.AttrGroupWithAttrsVo>
     * @Description: 获取分类下所有分组 & 关联属性
     **/
    @Override
    public List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId) {
        // 1、查询分组信息
        List<AttrGroupEntity> attrGroupEntities = this.list(new QueryWrapper<AttrGroupEntity>().eq("catelog_id", catelogId));
        // 2、查询所有属性
        List<AttrGroupWithAttrsVo> collect = attrGroupEntities.stream().map(attrGroupEntity -> {
            AttrGroupWithAttrsVo vo = new AttrGroupWithAttrsVo();
            BeanUtils.copyProperties(attrGroupEntity, vo);
            List<AttrEntity> attrs = attrService.getAttrRealtion(attrGroupEntity.getAttrGroupId());
            vo.setAttrs(attrs);
            return vo;
        }).collect(Collectors.toList());

        return collect;
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long catelogId) {

        String key = (String) params.get("key");
        // 要构造的 sql 语句为:
        // select * from pms_attr_group where catelog_id = ? and (attr_group_id = key or attr_group_name like %key%);
        QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(key)) {
//            System.out.println("key 不空");
            wrapper.and((obj) -> {
                obj.eq("attr_group_id", key).or().like("attr_group_name", key);
            });
        }

        // 1、先判断有没有分类ID，没有时会携带 0
        if (catelogId == 0) {
            // 此时要查询所有
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        } else {
            wrapper.eq("catelog_id", catelogId);
            IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
                    wrapper);
            return new PageUtils(page);
        }
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

}