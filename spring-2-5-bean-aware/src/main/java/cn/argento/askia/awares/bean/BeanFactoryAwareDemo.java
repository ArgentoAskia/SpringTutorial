package cn.argento.askia.awares.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryAwareDemo implements BeanFactoryAware {


    private BeanFactory beanFactory;
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryAwareDemo:" + beanFactory.getClass());
        this.beanFactory = beanFactory;
    }
}
