package com.tien.amall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.member.entity.IntegrationChangeHistoryEntity;

import java.util.Map;

/**
 * 积分变化历史记录
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-26 13:40:25
 */
public interface IntegrationChangeHistoryService extends IService<IntegrationChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

