package cn.argento.askia;

import cn.argento.askia.beans2.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 演示byType自动注入冲突的处理
 * 一般情况下出先自动注入冲突，采用按名字注入就可以解君愁！
 * 这里只说明注解形式的主选依赖和排除依赖
 */
@Configuration
// @ComponentScan如果扫面到了其他标记了@Configuration的配置类，会自动解析这些配置类并创建这些类里面所有标记了@Bean注解的方法的对象
@ComponentScan(basePackages = "cn.argento.askia.beans2")
public class SpringAutowiredOopContext {

    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Bean
    public LocalDateTime now(){
        return LocalDateTime.now();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Date now2(){
        return new Date();
    }


    // 直接创建user对象的话会触发User类Setter的@Autowired，所以创建出来的user1会和user2一模一样
    // 无论下面设置什么值，都会被User类Setter的@Autowired覆盖掉！
    // 所以使用了注解形式的Setter注入之后，请不要再创建对应的@Bean
    // 还是注入顺序的问题！！请关注@Autowired的注入顺序，在java-config章节中进行介绍！
    // @Configuration中调用方法VS@Component中调用方法
    // 是注入顺序的问题！！请关注@Autowired的注入顺序，在java-config章节中进行介绍！
    @Bean
    public User user1(){
        User user = new User();
        user.setBirthday(null);
        user.setId(null);
        user.setName(null);
        user.setUpload(null);
        return user;
    }
    @Bean
    public User2 user2(){
        User2 user2 = new User2();
        user2.setBirthday(null);
        user2.setId(null);
        user2.setName(null);
        user2.setUpload(null);
        return user2;
    }

    @Bean
    @Primary
    public User2 user3(){
        User2 user2 = new User2();
        final User user = user1();
        user2.setBirthday(user.getBirthday());
        user2.setId(user.getId());
        user2.setName(user.getName());
        user2.setUpload(user.getUpload());
        return user2;
    }
    //////////////////////
    // user1 user user2 user3都将会是同样的字段内容


    // 只有@Bean的注解能使用autowireCandidate属性
    // autowireCandidate的排除会影响@Autowire + @Qualified的注入,@Autowire + @Qualified的注入会找不到特定名称的bean
    // 类型冲突时@Component的Bean会优先于@Bean的bean
    @Bean(autowireCandidate = false)
    public Company company1(){
        Company company = new Company().setBirthday(new Date())
                .setId(123)
                .setName("123")
                .setTimes(3);
        return company;
    }

    // 只有@Bean的注解能使用autowireCandidate属性
    @Bean
    public Company company2(){
        Company company = new Company().setBirthday(new Date())
                .setId(1234)
                .setName("1234")
                .setTimes(34);
        return company;
    }
    // 只有@Bean的注解能使用autowireCandidate属性
    @Bean(autowireCandidate = false)
    public Company company3(){
        Company company = new Company().setBirthday(new Date())
                .setId(12343)
                .setName("12343")
                .setTimes(343);
        return company;
    }

    // @Primary既能作用于@Bean，也能作用于@Component
    @Bean
    public Area area1(){
        return new Area("Guangzhou");
    }

    @Bean
    @Primary
    public Area area2(){
        return new Area("Shandong");
    }



    @Bean
    @Autowired
    public Employee2 employee1(Company company, User2 user2, Area area){
        Employee2 employee = new Employee2(user2, company, area);
        return employee;
    }


}
