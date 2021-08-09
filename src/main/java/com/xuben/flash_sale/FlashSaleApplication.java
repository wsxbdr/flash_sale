package com.xuben.flash_sale;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = "com.xuben.flash_sale")
//@EnableTransactionManagement // 如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@MapperScan(annotationClass = Mapper.class, basePackages = "com.xuben.flash_sale.mapper")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
public class FlashSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlashSaleApplication.class, args);
    }

}
