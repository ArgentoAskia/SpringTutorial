package cn.argento.askia;


import cn.argento.askia.modes.beans.IP;
import cn.argento.askia.modes.config.FullModeConfig;
import cn.argento.askia.modes.config.LiteModeConfig;
import cn.argento.askia.overrides.config.OverrideContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.Native;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = OverrideContext.class)
public class OverrideTest {


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
    }
}
