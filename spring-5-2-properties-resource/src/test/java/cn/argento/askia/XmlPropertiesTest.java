package cn.argento.askia;

import cn.argento.askia.beans.JdbcBean;
import cn.argento.askia.beans.JdbcExtendsBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlPropertiesTest {

    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void before(){
        applicationContext = new ClassPathXmlApplicationContext("classpath:Spring-context.xml");
    }

    @After
    public void after(){
        applicationContext.close();
    }

    @Test
    public void testProperties(){
        JdbcBean jdbcBean = applicationContext.getBean("jdbcBean", JdbcBean.class);
        System.out.println(jdbcBean);
        JdbcExtendsBean jdbcExtendsBean = applicationContext.getBean("jdbcExtendsBean", JdbcExtendsBean.class);
        System.out.println(jdbcExtendsBean);
    }
}
