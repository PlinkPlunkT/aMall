package com.tien.amall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.member.entity.MemberEntity;

import java.util.Map;

/**
 * 会员
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:40:25
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

