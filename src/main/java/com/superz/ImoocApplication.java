package com.superz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.superz.mapper")
// 扫描所有需要的包，包括一些自用的工具类包所在路径
@ComponentScan(basePackages = {"com.superz", "org.n3r.idworker"})
// 开启定时任务
@EnableScheduling
// 开启异步调用方法
@EnableAsync
public class ImoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocApplication.class, args);
    }
}
