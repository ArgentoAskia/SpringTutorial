package cn.argentoaskia.bean;

import cn.argentoaskia.config.UserBeanConfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class User2BeanNameTest {

    private ApplicationContext applicationContext;
    private AnnotationConfigApplicationContext annotationConfigApplicationContext;
    @Before
    public void before(){
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(UserBeanConfig.class);
        applicationContext = new ClassPathXmlApplicationContext("classpath:/spring.xml");
    }

    @Test
    public void testNoNameBean(){
        User2 bean = applicationContext.getBean("cn.argentoaskia.bean.User2#0", User2.class);
        User2 bean2 = applicationContext.getBean("cn.argentoaskia.bean.User2#1", User2.class);
        System.out.println(bean);
        System.out.println(bean2);
    }

    @Test
    public void testBeanNameAttribute(){
        Object user2 = applicationContext.getBean("user2");
        Object user22 = applicationContext.getBean("user22");
        Object askia = applicationContext.getBean("askia");
        System.out.println("user2 == user22:" + (user2 == user22));
        System.out.println("user2 == askia:" + (user2 == askia));
        System.out.println(user2);
        System.out.println(user22);
        System.out.println(askia);
    }

    @Test
    public void testBeanAliasName(){
        Object defaultUser = applicationContext.getBean("defaultUser");
        Object user = applicationContext.getBean("user");
        System.out.println(defaultUser);
        System.out.println(user);
        System.out.println("user == defaultUser:" + (user == defaultUser));
    }

    @Test
    public void testAnnotationBean(){
        Object date = annotationConfigApplicationContext.getBean("date");
        Object localDateTime = annotationConfigApplicationContext.getBean("localDateTime");
        Object now = annotationConfigApplicationContext.getBean("now");

        System.out.println(date);
        System.out.println(localDateTime);
        System.out.println(now);
        User2 bean = annotationConfigApplicationContext.getBean(User2.class);
        System.out.println(bean);
    }

}
