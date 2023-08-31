package cn.argentoaskia.context;


import cn.argentoaskia.beans.bean.User3;
import org.springframework.context.LifecycleProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.DefaultLifecycleProcessor;

@Configuration
@ComponentScan
public class LifeCycleConfig {

    /**
     * 默认的lifecycle接口的处理器！
     * @return
     */
    @Bean
    public LifecycleProcessor lifecycleProcessor(){
        DefaultLifecycleProcessor defaultLifecycleProcessor = new DefaultLifecycleProcessor();
        return defaultLifecycleProcessor;
    }

    @Bean
    public User3 user3(){
        User3 user3 = new User3();
        return user3;
    }
}
