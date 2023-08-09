package cn.argentoaskia;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

/*
    xml--自动装配
    注解形式的配置
        依赖注入（@AutoWire、@Value、@Qualifier）
        bean作用范围（@Scope）
        创建对象推到容器（@Component、@Service、@Repository、@Controller）
    从原始的创建到整合JUnit
    Java-config配置@Configuration
        注解配置文件
        full、lite模式
    AOP基础（可能放在实训后面）
        JDK动态代理
        CGLIB
        AOP XML配置
        AOP 基础注解

 */
public class SpringContextTest {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:/spring.xml");
        String[] beanDefinitionNames = classPathXmlApplicationContext.getBeanDefinitionNames();
        for (String name :
                beanDefinitionNames) {
            Object bean = classPathXmlApplicationContext.getBean(name);
            System.out.println(name + " : " + bean);
        }
    }
}
