package cn.argento.askia;

import cn.argento.askia.context.ApplicationContextConfig;
import cn.argento.askia.context.ApplicationContextConfigExtends;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.util.Arrays;

public class ContextImportTest {

    private ClassPathXmlApplicationContext xmlApplicationContext;
    private ClassPathXmlApplicationContext xmlApplicationContextExtends;

    private AnnotationConfigApplicationContext annotationApplicationContext;
    private AnnotationConfigApplicationContext annotationApplicationContextExtends;


    @Before
    public void before(){
        xmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath:spring-context.xml");
        xmlApplicationContextExtends =
                new ClassPathXmlApplicationContext("classpath:spring-context-import.xml");
        annotationApplicationContext =
                new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        annotationApplicationContextExtends =
                new AnnotationConfigApplicationContext(ApplicationContextConfigExtends.class);
        xmlApplicationContext.start();
        xmlApplicationContextExtends.start();
        annotationApplicationContext.start();
        annotationApplicationContextExtends.start();
    }

    @After
    public void after(){
        xmlApplicationContext.stop();
        xmlApplicationContextExtends.stop();
        annotationApplicationContext.stop();
        annotationApplicationContextExtends.stop();
        xmlApplicationContext.close();
        xmlApplicationContextExtends.close();
        annotationApplicationContext.close();
        annotationApplicationContextExtends.close();
    }

    @Test
    public void testXmlApplicationContext(){
        System.out.println("===================== XmlApplicationContext =====================");
        int beanDefinitionCount = xmlApplicationContext.getBeanDefinitionCount();
        String[] beanDefinitionNames = xmlApplicationContext.getBeanDefinitionNames();
        System.out.println("spring-context.xml容器里面有" + beanDefinitionCount + "个对象");
        System.out.println("他们的id是：" + Arrays.toString(beanDefinitionNames));
        System.out.println("===================== XmlApplicationContext =====================");
        System.out.println();
    }
    @Test
    public void testXmlApplicationContextExtends(){
        System.out.println("===================== XmlApplicationContextExtends =====================");
        System.out.println("XmlApplicationContextExtends 继承自 XmlApplicationContext");
        int beanDefinitionCount = xmlApplicationContextExtends.getBeanDefinitionCount();
        String[] beanDefinitionNames = xmlApplicationContextExtends.getBeanDefinitionNames();
        System.out.println("spring-context-import.xml容器里面有" + beanDefinitionCount + "个对象");
        System.out.println("他们的id是：" + Arrays.toString(beanDefinitionNames));
        System.out.println("===================== XmlApplicationContextExtends =====================");
        System.out.println();
    }
    @Test
    public void testAnnotationApplicationContext(){
        System.out.println("===================== AnnotationApplicationContext =====================");
        System.out.println("AnnotationApplicationContext 继承自 XmlApplicationContextExtends");
        int beanDefinitionCount = annotationApplicationContext.getBeanDefinitionCount();
        String[] beanDefinitionNames = annotationApplicationContext.getBeanDefinitionNames();
        System.out.println("ApplicationContextConfig.class容器里面有" + beanDefinitionCount + "个对象");
        System.out.println("他们的id是：" + Arrays.toString(beanDefinitionNames));
        System.out.println("===================== AnnotationApplicationContext =====================");
        System.out.println();
    }
    @Test
    public void testAnnotationApplicationContextExtends(){
        System.out.println("===================== AnnotationApplicationContextExtends =====================");
        System.out.println("AnnotationApplicationContextExtends 继承自 AnnotationApplicationContext");
        int beanDefinitionCount = annotationApplicationContextExtends.getBeanDefinitionCount();
        String[] beanDefinitionNames = annotationApplicationContextExtends.getBeanDefinitionNames();
        System.out.println("ApplicationContextConfigExtends.class容器里面有" + beanDefinitionCount + "个对象");
        System.out.println("他们的id是：" + Arrays.toString(beanDefinitionNames));
        System.out.println("===================== AnnotationApplicationContextExtends =====================");
        System.out.println();
    }

}
