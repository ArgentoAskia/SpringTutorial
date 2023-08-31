package cn.argento.askia.awares;

import cn.argento.askia.SpringContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AwaresTest {

    private AnnotationConfigApplicationContext applicationContext;
    @Before
    public void before(){
        applicationContext = new AnnotationConfigApplicationContext(SpringContext.class);
    }

    @After
    public void after(){
        applicationContext.registerShutdownHook();
    }

    @Test
    public void test(){
        applicationContext.getBean("user4First");
    }




}
