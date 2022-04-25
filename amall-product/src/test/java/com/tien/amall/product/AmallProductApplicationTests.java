package com.tien.amall.amallproduct;

import com.tien.amall.product.entity.BrandEntity;
import com.tien.amall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AmallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setDescript("非常好的手机");
        brandEntity.setName("Pear");
        brandService.save(brandEntity);
        System.out.println("保存成功！");
    }

}
