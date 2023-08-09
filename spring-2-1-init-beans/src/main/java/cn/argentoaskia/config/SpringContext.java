package cn.argentoaskia.config;

import cn.argentoaskia.beans.User;
import cn.argentoaskia.factory.UserObjectFactory;
import cn.argentoaskia.factory.UserStaticFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;

/**
 * Spring 3.0引入的初始化方式，一般用于初始化自己没有源代码的bean。
 * 很好地弥补了2.5版本中@Component的不足。
 * 在这种配置方式中，已经没有所谓的factory-bean、factory-method之分了。
 * 只需要在方法上面加上@Bean，则Spring则会运行这个方法，把返回值放在对象容器内。
 * ------------------------
 * @Configuration实际上也是@Component，容器初始化也会创建SpringContext的对象。
 * 因此你可以直接使用getBean(SpringContext.class)来获取对象，但是和@Component有区别（full&lite模式）
 */
@Configuration
// @ComponentScan相当于context:component-scan标签，
// @ComponentScan为了安全可以指定Class所在包来实现扫描（basePackageClasses属性）
@ComponentScan(basePackageClasses = User.class)
public class SpringContext {

    @Bean
    public User userDefault(){
        System.out.println("userDefault方法执行了...");
        return new User();
    }

    @Bean
    public User user3(){
        System.out.println("user3方法执行了...");
        UserObjectFactory userObjectFactory = new UserObjectFactory();
        return userObjectFactory.createUser();
    }

    @Bean
    public User user4(){
        System.out.println("user4方法执行了...");
        return UserStaticFactory.createDefaultUser();
    }
}
