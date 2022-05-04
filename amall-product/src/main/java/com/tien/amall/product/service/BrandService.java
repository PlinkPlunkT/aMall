package com.tien.amall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 20:33:52
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}

