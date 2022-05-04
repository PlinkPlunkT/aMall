package com.tien.amall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.product.entity.AttrEntity;

import java.util.Map;

/**
 * 商品属性
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 20:33:52
 */
public interface AttrService extends IService<AttrEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

