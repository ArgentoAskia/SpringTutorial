package cn.argentoaskia.config;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AliasFor;

import java.time.LocalDateTime;
import java.util.Date;

//@ImportResource("classpath:/spring.xml")


// 2.起名规则同@Component
@Configuration("userBeanConfig")
// 建议采用basePackageClasses，采用basePackage怕写错
@ComponentScan("cn.argentoaskia.bean")
public class UserBeanConfig {

    // 3.@Bean的起名方式，可以通过传递数组的方式来实现指定多个命名。
    // 如果不指定任何名字的情况下，默认以小写类名作为bean的id
    @Bean("date")
    public Date date(){
        Date date = new Date();
        return date;
    }

    @Bean({"now", "localDateTime"})
    public LocalDateTime localDateTime(){
        return LocalDateTime.now();
    }
}
