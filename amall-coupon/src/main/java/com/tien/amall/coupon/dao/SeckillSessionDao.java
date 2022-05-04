package com.tien.amall.coupon.dao;

import com.tien.amall.coupon.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:48:33
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
