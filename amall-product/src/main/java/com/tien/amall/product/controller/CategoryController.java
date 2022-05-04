package com.tien.amall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tien.amall.product.entity.CategoryEntity;
import com.tien.amall.product.service.CategoryService;
import com.tien.common.utils.PageUtils;
import com.tien.common.utils.R;



/**
 * 商品三级分类
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 22:01:55
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查询所有分类及子分类，以树形结构组装
     */
    @RequestMapping("/list/tree")
    // @RequiresPermissions("product:category:list")
    public R list(){

        // 以树形结构返回所有的种类
        List<CategoryEntity> entities = categoryService.listWithTree();

        return R.ok().put("data", entities);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    // @RequiresPermissions("product:category:info")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:category:save")
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * @Author: Acme Tien
     * @Date: 2022/5/2 15:44
     * @Email: bhappy1314i@gmail.com
     * @Params: category: 前端穿进来的需要修改的种类
     * @return:
     * @Description: 批量修改分类
     **/
    @RequestMapping("/update/sort")
    // @RequiresPermissions("product:category:update")
    public R updateSort(@RequestBody CategoryEntity[] category){
        // 批量修改
        categoryService.updateBatchById(Arrays.asList(category));

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:category:update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateCascade(category);
        return R.ok();
    }

    /**
     * 删除某个种类
     * @RequestBody: 获取请求体，只有 POST 才有请求体
     * SpringMVC 会自动将请求体的数据 (json) 转换为对应的对象
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:category:delete")
    public R delete(@RequestBody Long[] catIds){

        // 删除方法编写：
        // 1、检查要删除的菜单是否被别人引用



		categoryService.removeCategoryByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
