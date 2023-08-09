import cn.argentoaskia.beans.User;
import cn.argentoaskia.config.SpringContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansInitTest {



    private ApplicationContext applicationContext;
    private ApplicationContext annotationApplicationContext;
    @Before
    public void before(){
        annotationApplicationContext = new AnnotationConfigApplicationContext(SpringContext.class);
        applicationContext = new ClassPathXmlApplicationContext("classpath:/Spring.xml");
    }


    /**
     * 构造器测试
     */
    @Test
    public void testConstructorInitUserObject(){
        User userByConstructor = applicationContext.getBean("userByConstructor", User.class);
        System.out.println(userByConstructor);
    }

    /**
     * 静态方法初始化测试
     */
    @Test
    public void testStaticFactoryInitUserObject(){
        User userByStaticFactory = applicationContext.getBean("userByStaticFactory", User.class);
        System.out.println(userByStaticFactory);
    }

    /**
     * 工厂方法测试
     */
    @Test
    public void testObjectFactoryInitUserObject(){
        User userByObjectFactory = applicationContext.getBean("userByObjectFactory", User.class);
        System.out.println(userByObjectFactory);
    }

    @Test
    public void testAnnotationCreate(){
        Object aDefault = applicationContext.getBean("default");
        System.out.println(aDefault);
    }

    @Test
    public void testJavaConfigCreate(){
        Object user4 = annotationApplicationContext.getBean("user4");
        Object user3 = annotationApplicationContext.getBean("user3");
        Object userDefault = annotationApplicationContext.getBean("userDefault");
        Object defaultBean = annotationApplicationContext.getBean("default");
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(userDefault);
        System.out.println(defaultBean);
    }




}
