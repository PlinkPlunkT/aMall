package com.tien.amall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.coupon.entity.SeckillSkuNoticeEntity;

import java.util.Map;

/**
 * 秒杀商品通知订阅
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:48:33
 */
public interface SeckillSkuNoticeService extends IService<SeckillSkuNoticeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

