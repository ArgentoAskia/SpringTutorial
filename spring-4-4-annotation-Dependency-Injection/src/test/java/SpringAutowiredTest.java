import cn.argentoaskia.SpringAnnotationAutowireContext;
import cn.argentoaskia.beans.LocalDateTimeDependOnBean;
import cn.argentoaskia.beans.MoreValueAnnotationAutowired;
import cn.argentoaskia.beans.MoreAutowiredByFields;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAnnotationAutowireContext.class)
public class SpringAutowiredTest {

    @Autowired
    private MoreValueAnnotationAutowired moreValueAnnotationAutowired;

    @Autowired
    private MoreAutowiredByFields moreAutowiredByFields;


    @Autowired
    private LocalDateTimeDependOnBean localDateTimeDependOnBean;

    @Autowired
    @Qualifier("localDateTime2")
    private LocalDateTime localDateTime2;

    @Autowired
    @Qualifier("localDateTime")
    private LocalDateTime localDateTime;


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test(){
        System.out.println(moreValueAnnotationAutowired);
    }

    @Test
    public void test2(){
        System.out.println(moreAutowiredByFields);
    }

    @Test
    public void test3(){
        System.out.println(localDateTimeDependOnBean);
    }

    @Test
    public void test4(){
        System.out.println("not lazy bean：" + localDateTime);
        System.out.println("lazy bean：" + localDateTime2);
    }

    @Test
    public void showContext(){
        System.out.println("======================= Context Beans =======================");
        final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName :
                beanDefinitionNames) {
            final Object bean = applicationContext.getBean(beanName);
            System.out.println(bean);
        }
        System.out.println("============================================================");
    }

}
