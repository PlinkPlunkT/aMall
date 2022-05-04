package com.tien.amall.member.dao;

import com.tien.amall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:40:25
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
