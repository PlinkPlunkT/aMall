package com.tien.amall.member.feign;

import com.tien.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("amall-coupon") // 告诉 Spring Cloud 这个接口是一个远程客户端，使用的服务名是 amall-coupon
public interface CouponFeignService {

    // 需要远程调用的服务的方法签名
    @RequestMapping("/coupon/coupon/member/list")
    R memberCoupons();
}
