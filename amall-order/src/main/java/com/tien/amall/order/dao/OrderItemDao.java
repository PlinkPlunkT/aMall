package com.tien.amall.order.dao;

import com.tien.amall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:50:34
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
