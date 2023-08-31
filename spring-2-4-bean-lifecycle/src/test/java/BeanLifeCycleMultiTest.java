import cn.argentoaskia.bean.User3;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleMultiTest {

    private ClassPathXmlApplicationContext applicationContext;

    @Before
    public void init(){
        applicationContext = new ClassPathXmlApplicationContext("/spring-context-2.xml");
    }

    @After
    public void destroy(){
        System.out.println("准备关闭容器");
        applicationContext.close();
        System.out.println("容器已关闭");
    }

    @Test
    public void testAllLifeCycle(){
        User3 bean = applicationContext.getBean(User3.class);
        System.out.println(bean);
    }
}
