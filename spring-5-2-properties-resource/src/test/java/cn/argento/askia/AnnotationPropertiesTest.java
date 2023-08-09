package cn.argento.askia;

import cn.argento.askia.beans.JdbcBean;
import cn.argento.askia.beans.JdbcExtendsBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AnnotationPropertiesTest {
    private AnnotationConfigApplicationContext applicationContext;

    @Before
    public void before(){
        applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    @After
    public void after(){
        applicationContext.close();
    }

    @Test
    public void testProperties(){
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));
        System.out.println();
        SpringConfig springConfig = applicationContext.getBean("springConfig", SpringConfig.class);
        System.out.println(springConfig);
        System.out.println();
        JdbcBean jdbcBean2 = applicationContext.getBean("jdbcBean2", JdbcBean.class);
        System.out.println(jdbcBean2);
        System.out.println();
        springConfig.printEnvs();
    }
}
