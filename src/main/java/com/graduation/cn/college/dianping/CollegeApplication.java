package com.graduation.cn.college.dianping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.graduation.cn.college.dianping"})
@MapperScan("com.graduation.cn.college.dianping.dal")
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
public class CollegeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegeApplication.class, args);
    }

}
