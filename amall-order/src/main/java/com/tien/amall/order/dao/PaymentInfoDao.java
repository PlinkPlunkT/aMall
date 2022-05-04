package com.tien.amall.order.dao;

import com.tien.amall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:50:34
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
