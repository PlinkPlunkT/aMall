package com.tien.amall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.tien.amall.product.entity.AttrEntity;
import com.tien.amall.product.service.AttrAttrgroupRelationService;
import com.tien.amall.product.service.AttrService;
import com.tien.amall.product.service.CategoryService;
import com.tien.amall.product.vo.AttrGroupRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tien.amall.product.entity.AttrGroupEntity;
import com.tien.amall.product.service.AttrGroupService;
import com.tien.common.utils.PageUtils;
import com.tien.common.utils.R;



/**
 * 属性分组
 *
 * @author AcmeTien
 * @email bhappy1314i@gmail.com
 * @date 2022-04-25 22:01:55
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    AttrAttrgroupRelationService relationService;

    /**
     * @Author: Acme Tien
     * @Date: 2022/5/5 22:07
     * @Email: bhappy1314i@gmail.com
     * @Params:
     * @return:
     * @Description: 添加关联关系
     **/
    // /product/attrgroup/attr/relation
    @PostMapping("/attr/relation")
    public R addRelation(@RequestBody List<AttrGroupRelationVo> vos) {

        relationService.saveBatch(vos);
        return R.ok();
    }


    /**
     * @Author: Acme Tien
     * @Date: 2022/5/5 22:05
     * @Email: bhappy1314i@gmail.com
     * @Params:
     * @return:
     * @Description: 获取属性分组里面还没有关联的本分类里面的其他基本属性，方便添加新的关联
     **/
    // /product/attrgroup/{attrgroupId}/noattr/relation
    @GetMapping("/{attrgroupId}/noattr/relation")
    public R attrNoRelation(@RequestParam Map<String, Object> params,
                            @PathVariable("attrgroupId") Long attrgroupId) {
        // 分页方法，要传入分页信息
        PageUtils page = attrService.getNoRelationAttr(params, attrgroupId);
        return R.ok().put("page", page);
    }

    // /product/attrgroup/attr/relation/delete
    // Post 请求携带来的 JSON 数据，要封装为我们自己的对象，需要加一个 @RequestBody 注解
    @PostMapping("/attr/relation/delete")
    public R deleteRealation(@RequestBody AttrGroupRelationVo[] vos) {
        attrService.deletaRelation(vos);
        return R.ok();
    }


    /**
     * @Author: Acme Tien
     * @Date: 2022/5/5 20:39
     * @Email: bhappy1314i@gmail.com
     * @Params:
     * @return:
     * @Description: 获取属性分组的关联的所有属性
     **/
    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId) {
        List<AttrEntity> entities = attrService.getAttrRealtion(attrgroupId);
        return R.ok().put("data", entities);
    }


    /**
     * 列表
     *  catelogId : 三级分类ID，是路径变量，需要在方法签名上声明
     */
    @GetMapping("/list/{catelogId}")
    // @RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params,
                  @PathVariable("catelogId") Long catelogId){

        // PageUtils page = attrGroupService.queryPage(params);
        PageUtils page = attrGroupService.queryPage(params, catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    // @RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);

        Long catelogId = attrGroup.getAttrGroupId();
        // 找到当前分类的完整路径
        Long[] path = categoryService.findCatelogPath(catelogId);

        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    // @RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    // @RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    // @RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
