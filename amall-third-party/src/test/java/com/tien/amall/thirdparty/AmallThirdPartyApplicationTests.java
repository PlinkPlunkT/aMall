package com.tien.amall.thirdparty;

import com.aliyun.oss.OSS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class AmallThirdPartyApplicationTests {

    @Autowired
    OSS ossClient;

    @Test
    public void testUpload() throws FileNotFoundException {
        String bucketName = "amall-acme";
        String fileName = "exampledir/test3.jpg";
        ossClient.putObject(bucketName, fileName, new FileInputStream("/Users/tien/Pictures/ishot/iShot2021-12-27 13.42.26.jpg"));
        System.out.println("上传成功！");
    }

    @Test
    void contextLoads() {
    }

}
