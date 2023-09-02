package cn.argento.askia;

import cn.argento.askia.overrides.config.OverrideContext;
import cn.argento.askia.statics.config.StaticContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StaticContext.class)
public class StaticTest {

    @Autowired
    private ApplicationContext applicationContext;


    @Test
    public void printContext(){
        final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName :
                beanDefinitionNames) {
            final Object bean = applicationContext.getBean(beanName);
            System.out.println(beanName + " = " + bean);
        }
        System.out.println(StaticContext.getIp());
    }
}
