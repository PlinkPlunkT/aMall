package com.tien.amall.product.service.impl;

import com.tien.amall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tien.common.utils.PageUtils;
import com.tien.common.utils.Query;

import com.tien.amall.product.dao.BrandDao;
import com.tien.amall.product.entity.BrandEntity;
import com.tien.amall.product.service.BrandService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Transactional
    @Override
    public void updateDetail(BrandEntity brand) {
        // 保证冗余字段的数据一致
        this.updateById(brand);
        if (StringUtils.hasLength(brand.getName())) {
            // 如果品牌名不为空，就要同步更新其他关联表中的数据
            categoryBrandRelationService.updateBrand(brand.getBrandId(), brand.getName());

            // TODO: 更新其他关联
        }
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        // 实现模糊查询
        // 1、获取 key
        String key = (String) params.get("key");
        QueryWrapper<BrandEntity> queryWrapper = new QueryWrapper<>();
        if (StringUtils.hasLength(key)) {
            // queryWrapper.eq("brand_id", key).or().like("name", key);
            queryWrapper.eq("brand_id", key).or().like("name", key);
        }
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }

}