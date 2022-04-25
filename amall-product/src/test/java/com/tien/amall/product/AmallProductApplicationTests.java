package com.tien.amall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tien.amall.product.entity.BrandEntity;
import com.tien.amall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AmallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("也没那么好");
//        brandService.updateById(brandEntity);
//        System.out.println("修改成功！");
//        brandEntity.setDescript("非常好的手机");
//        brandEntity.setName("Pear");
//        brandService.save(brandEntity);
//        System.out.println("保存成功！");
        List<BrandEntity> list = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        list.forEach((item) -> {
            System.out.println(item);
        });
    }

}
