package com.tien.amall.product.service.impl;

import com.tien.amall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tien.common.utils.PageUtils;
import com.tien.common.utils.Query;

import com.tien.amall.product.dao.CategoryDao;
import com.tien.amall.product.entity.CategoryEntity;
import com.tien.amall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1、查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        // 2、组装成父子树形结构
        // 2.1 找出所有的一级分类（父分类ID 是 0）
        List<CategoryEntity> level1Categories = entities.stream().filter(categoryEntity ->
                categoryEntity.getParentCid() == 0
        ).map((category) -> {
            category.setChildren(getChildren(category, entities));
            return category;
        }).sorted(Comparator.comparingInt(category ->
                (category.getSort() == null ? 0 : category.getSort()))
        ).collect(Collectors.toList());


        return level1Categories;
    }

    // 递归查找所有分类的子分类
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {

        List<CategoryEntity> children = all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            // 1、找到子分类
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted(Comparator.comparingInt(category -> (category.getSort() == null ? 0 : category.getSort()))).collect(Collectors.toList());
        return children;
    }

    /**
     * @Author: Acme Tien
     * @Date: 2022/5/4 23:15
     * @Email: bhappy1314i@gmail.com
     * @Params: category
     * @return:
     * @Description: 级联更新所有数据
     **/
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        // 先更新自己
        this.updateById(category);
        // 更新关联表中的信息
        categoryBrandRelationService.updateCategory(category.getCatId(), category.getName());
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, paths);
        Collections.reverse(parentPath);

        return parentPath.toArray(new Long[0]);
    }

    private List<Long> findParentPath(Long catelogId, List<Long> paths) {
        // 递归收集父 ID
        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if (byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(), paths);
        }
        return paths;
    }

    @Override
    public void removeCategoryByIds(List<Long> asList) {
        // TODO: 检查当前删除的菜单，是否被其他地方引用
        // 开发期间多使用逻辑删除
        baseMapper.deleteBatchIds(asList);
    }
}