package cn.argento.askia.statics.config;

import cn.argento.askia.statics.bean.IP;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class StaticContext implements ApplicationContextAware {
    // 无法注入静态变量！！
//    @Autowired
//    @Qualifier("ip2")
    private static IP ip;

    // 但可以通过这种方式进行静态字段注入！
    @Autowired
    public void setIp(IP ip){
        StaticContext.ip = ip;
    }

    public static IP getIp() {
        return ip;
    }

    // 静态方法也能创建Bean
    @Bean
    public static IP ip() throws UnknownHostException {
        final InetAddress localHost = InetAddress.getLocalHost();
        return new IP(localHost);
    }

    @Bean
    public IP ip2() throws UnknownHostException {
        final IP ip = ip();
        final IP ip2 = ip();
        System.out.println(ip);
        System.out.println(ip2);
        System.out.println("ip == ip2：" + (ip == ip2));
        return new IP();
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
