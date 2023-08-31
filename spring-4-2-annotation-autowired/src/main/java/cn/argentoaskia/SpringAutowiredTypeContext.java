package cn.argentoaskia;


import cn.argentoaskia.beans.Company;
import cn.argentoaskia.beans.Employee;
import cn.argentoaskia.beans.User;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 注解形式自动注入方法演示（byName、byType）
 * {@code @AutoWire}默认就是byType注入！
 * 如果希望使用byName注入可以通过添加@Qualifier实现
 * 如果是@Bean注解，则可以配置autowired属性来指定创建的@Bean是byType注入还是byName注入！
 */
@Configuration
@ComponentScan(basePackages = "cn.argentoaskia.beans")
public class SpringAutowiredTypeContext {


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


    // 创建多个bean，用来制造byName注入

    @Bean
    public Company company1(){
        Company company = new Company().setBirthday(new Date())
                .setId(123)
                .setName("123")
                .setTimes(3);
        return company;
    }


    // 基于@Bean的byName注册
    // 注意，无需进行任何的对象注入，Spring会拿到Employee的setter方法，根据Setter方法的方法名来进行注入（不看字段！）
    // 注意这种方式Spring 5.1以后已标记废弃
    // 这种注入要求对象id要和setter方法的一致！
    @Bean(autowire = Autowire.BY_NAME)
    public Employee employee1(){
        Employee employee = new Employee();
        return employee;
    }

    // 基于@Bean的byType注入（按照类型来注入！）
    // 注意这种方式Spring 5.1以后已标记废弃
    // 这里理论上会出现类型注入冲突，因为Company有两个对象再容器：company1和company
    // 但实际测试并没有发现出现冲突，原因未知，注入会直接使用@Bean的company1而不使用@Component的company
    // 目前原因知道了，因为setCompany()方法标记了@Autowired
    // byType注入会被@Autowired的Setter方法注入覆盖！
    // @Bean注入会覆盖构造器注入
    // 因此注入顺序：构造器注入 > @Bean > Setter @Autowired
    // Setter @Autowired会覆盖前面两个的结果，因此Employee的Setter不能标记@Autowire,去掉之后就会冲突！
//    @Bean(autowire = Autowire.BY_TYPE)
//    public Employee employee2(){
//        Employee employee2 = new Employee();
//        return employee2;
//    }

    // 5.1之后，@Autowire直接干废了autowire属性
    // 单独的@Autowire就是按类型注入
    // @Autowire + @Qualifier 则是byName
    // 如这里：Company是byName注册，而user则是byType
    @Bean
    @Autowired
    public Employee employee3(@Qualifier("company1") Company company, User user){
        Employee employee = new Employee(user, company);
        return employee;
    }



}
