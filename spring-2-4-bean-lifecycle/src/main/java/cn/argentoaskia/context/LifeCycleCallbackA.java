package cn.argentoaskia.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LifeCycleCallbackA implements Lifecycle, ApplicationContextAware {

    private volatile boolean running = false;
    private volatile ApplicationContext applicationContext;

    @Override
    public void start() {
        System.out.println("=========== LifeCycleCallbackA ===========");
        System.out.println("Start Solve With Callback, you will see some messages for Context...");
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        long startupDate = applicationContext.getStartupDate();
        System.out.println("容器内bean数量：" + beanDefinitionCount);
        System.out.println("容器内bean名称：" + Arrays.toString(beanDefinitionNames));
        System.out.println("容器启动时间：" + startupDate);
        this.running = true;
        System.out.println("=========== LifeCycleCallbackA ===========");
    }

    @Override
    public void stop() {
        System.out.println("=========== LifeCycleCallbackA ===========");
        System.out.println("关闭容器回调...");
        int beanDefinitionCount = applicationContext.getBeanDefinitionCount();
        System.out.println("容器内bean数量：" + beanDefinitionCount);
        this.running = false;
        System.out.println("=========== LifeCycleCallbackA ===========");
    }

    @Override
    public boolean isRunning() {
        System.out.println("当前LifeCycleCallbackA运行状态" + running);
        return running;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
