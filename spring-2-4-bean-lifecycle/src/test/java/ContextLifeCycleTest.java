import cn.argentoaskia.bean.User3;
import cn.argentoaskia.context.LifeCycleConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ContextLifeCycleTest {

    private AnnotationConfigApplicationContext applicationContext;
    @Before
    public void init(){
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        //  Lifecycle必须要显示调用否则无效
        applicationContext.start();
    }

    @After
    public void destroy(){
        applicationContext.stop();
        applicationContext.close();
    }


    @Test
    public void testCycle(){
        User3 bean = applicationContext.getBean(User3.class);
    }

}
