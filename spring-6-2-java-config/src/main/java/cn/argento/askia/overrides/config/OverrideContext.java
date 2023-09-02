package cn.argento.askia.overrides.config;

import cn.argento.askia.overrides.beans.IP;
import cn.argento.askia.overrides.beans.IP2;
import cn.argento.askia.overrides.beans.IP3;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.management.MXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 我们在这里构建了三个Bean：
 * IP：使用构造器注入
 * IP2：使用字段注入
 * IP3：使用Setter注入
 * 同时分别使用@Bean的方式再次创建他们的对象:ip、ip2、ip3
 * 奇怪的是，除了IP之外，其他的ip2、ip3都会被IP2、IP3覆盖
 * IP2的内容会和ip2一模一样、IP3的内容会和ip3一模一样，但他们不是同一个对象（hash值不同！）
 *
 * 然后我们创建一个User类，该类内部需要一个IP对象、一个IP2、一个IP3
 * 由于目前容器内存在多个IP对象，理论上可能会产生注入冲突
 * 但测试结果却没有，注入到User的都是@Bean的对象
 * 于是添加了一个@Bean的ip4()，可还是会注入ip对象
 *
 * 我们尝试更改ip对象的名字，将ip()改成i(),结果开始报注入失败错误，说找到3个对象！
 *
 * 到这里似乎可以得出结论了：
 * 场景：当一个类即被@Component标记、有在配置类中使用@Bean创建的时候！
 * 1. @Component标记的类如果不是特殊原因（存在循环依赖、单例等），建议优先使用构造器注入，@Bean创建的对象会被字段注入和Setter注入覆盖
 * 2. 当知道容器内存在多个类型相同的bean时，想要注入一定要使用byName的方式！首先注入的优先级似乎都是@Bean的优先，并且部分情况（暂未清楚是哪部分情况，但知道有这种情况）下
 *      即便有多个同类型的@Bean也能进行注入，如ip()和ip4()，因此请不要相信任何的优先级歧义而放弃使用byName！
 */
@Configuration
@ComponentScan("cn.argento.askia.overrides.beans")
public class OverrideContext implements ApplicationContextAware {

    @Bean
    public IP ip4(){
        final IP ip = new IP();
        return ip;
    }
    @Bean
    public IP ip(){
        try {
            final InetAddress localHost = InetAddress.getLocalHost();
            final IP ip = new IP(localHost);
            return ip;
        } catch (UnknownHostException e) {
           throw new RuntimeException(e);
        }
    }
    @Bean
    public IP2 ip2(){
        try {
            final InetAddress localHost = InetAddress.getLocalHost();
            IP2 ip2 = new IP2(localHost);
            return ip2;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public IP3 ip3(){
        try {
            final InetAddress localHost = InetAddress.getLocalHost();
            IP3 ip3 = new IP3(localHost);
            return ip3;
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    public ApplicationContext applicationContext(){
        return applicationContext;
    }
}
