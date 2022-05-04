package com.tien.amall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tien.common.utils.PageUtils;
import com.tien.amall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 20:33:51
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);


    List<CategoryEntity> listWithTree();

    void removeCategoryByIds(List<Long> asList);

    /**
     * @Author: Acme Tien
     * @Date: 2022/5/4 21:36
     * @Email: bhappy1314i@gmail.com
     * @Params:
     * @return:
     * @Description: 找到 catelogId 的完整路径： 父/子/孙
     **/
    Long[] findCatelogPath(Long catelogId);

    void updateCascade(CategoryEntity category);
}

