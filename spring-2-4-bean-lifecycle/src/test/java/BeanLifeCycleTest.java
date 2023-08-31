import cn.argentoaskia.beans.bean.User3;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {

    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("/spring-context.xml");
    }

    @After
    public void destroy(){
        System.out.println("准备关闭容器");
        applicationContext.close();
        System.out.println("容器已关闭");
    }

    @Test
    public void testAllLifeCycle(){
        User3 user3_1 = applicationContext.getBean("user3_1", User3.class);
        User3 user3_2 = applicationContext.getBean("user3_2", User3.class);
        User3 user3_3 = applicationContext.getBean("user3_3", User3.class);
        User3 user3_4 = applicationContext.getBean("user3_4", User3.class);
        System.out.println(user3_1);
        System.out.println(user3_2);
        System.out.println(user3_3);
        System.out.println(user3_4);
    }
}
