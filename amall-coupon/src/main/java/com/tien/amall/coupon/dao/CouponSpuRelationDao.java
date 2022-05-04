package com.tien.amall.coupon.dao;

import com.tien.amall.coupon.entity.CouponSpuRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券与产品关联
 * 
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:48:32
 */
@Mapper
public interface CouponSpuRelationDao extends BaseMapper<CouponSpuRelationEntity> {
	
}
