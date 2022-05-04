package com.tien.amall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.product.entity.SpuInfoEntity;

import java.util.Map;

/**
 * spu信息
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 20:33:51
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

