package cn.argento.askia.awares.bean;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.stereotype.Component;

@Component
public class BeanClassLoaderAwareDemo implements BeanClassLoaderAware {
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("BeanClassLoaderAwareDemo：" + classLoader);
    }
}
