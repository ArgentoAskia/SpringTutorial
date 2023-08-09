package cn.argentoaskia;

import cn.argentoaskia.config.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class ContainerTest {

    private ClassPathXmlApplicationContext classPathXmlApplicationContext;
    private AnnotationConfigApplicationContext annotationConfigApplicationContext;
    private Random random;
    @Before
    public void before(){
        random = new Random();
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:/spring.xml");
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Context.class);
    }
    @After
    public void after(){

    }
    @Test
    public void testSingletonBean() throws InterruptedException {
        Date date2 = annotationConfigApplicationContext.getBean("date2", Date.class);
        Thread.sleep(1000 + random.nextInt(2000));
        Date date3 = annotationConfigApplicationContext.getBean("date2", Date.class);
        System.out.println("date2 == date3: " + (date2 == date3));
        System.out.println("date2 =" + date2);
        System.out.println("date3 =" + date3);

        LocalDateTime now2 = classPathXmlApplicationContext.getBean("now2", LocalDateTime.class);
        Thread.sleep(1000 + random.nextInt(2000));
        LocalDateTime now3 = classPathXmlApplicationContext.getBean("now2", LocalDateTime.class);
        System.out.println("now2 == now3: " + (now2 == now3));
        System.out.println("now2 =" + now2);
        System.out.println("now3 =" + now3);
    }

    @Test
    public void testPrototypeBean() throws InterruptedException {
        Date date2 = annotationConfigApplicationContext.getBean("date", Date.class);
        Thread.sleep(1000 + random.nextInt(2000));
        Date date3 = annotationConfigApplicationContext.getBean("date", Date.class);
        System.out.println("date2 == date3: " + (date2 == date3));
        System.out.println("date2 =" + date2);
        System.out.println("date3 =" + date3);

        LocalDateTime now2 = classPathXmlApplicationContext.getBean("now", LocalDateTime.class);
        Thread.sleep(1000 + random.nextInt(2000));
        LocalDateTime now3 = classPathXmlApplicationContext.getBean("now", LocalDateTime.class);
        System.out.println("now2 == now3: " + (now2 == now3));
        System.out.println("now2 =" + now2);
        System.out.println("now3 =" + now3);
    }
}
