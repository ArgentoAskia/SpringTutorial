package cn.argento.askia;

import cn.argento.askia.bean.User4;
import cn.argento.askia.bean.User4WithBeanNameAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class SpringContext {

    @Bean("user4First")
    public User4 createUser4First(){
        User4WithBeanNameAware user4WithBeanNameAware = new User4WithBeanNameAware();
        return user4WithBeanNameAware;
    }
    @Bean("user4Second")
    public User4 createUser4Second(){
        User4WithBeanNameAware user4WithBeanNameAware = new User4WithBeanNameAware();
        return user4WithBeanNameAware;
    }
    @Bean("user4Third")
    public User4 createUser4Third(){
        User4WithBeanNameAware user4WithBeanNameAware = new User4WithBeanNameAware();
        return user4WithBeanNameAware;
    }

}
