package com.tien.amall.coupon;

import com.tien.amall.coupon.entity.CouponEntity;
import com.tien.amall.coupon.service.CouponService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class AmallCouponApplicationTests {

    @Autowired
    CouponService couponService;
    @Test
    void contextLoads() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满 100 减 20");
        couponEntity.setAmount(BigDecimal.valueOf(20));
//        couponService.removeById(1L);
        System.out.println("成功！");
    }
}
