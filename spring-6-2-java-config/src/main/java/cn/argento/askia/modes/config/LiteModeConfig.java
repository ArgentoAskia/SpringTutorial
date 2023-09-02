package cn.argento.askia.modes.config;


import cn.argento.askia.modes.beans.IP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

// lite模式下调用inetAddress()不会被代理，因此你会看到两次信息（一次是创建Bean时调用，另外一次时创建IP对象时进行调用）
// lite模式下调用inetAddress()就是普通的调用方法
// 因此ip()的对象实际上时第二次调用方法时创建的而不是使用容器中的
@Component
@ComponentScan("cn.argento.askia.beans")
public class LiteModeConfig {

    private static boolean flag = true;

    @Bean
    public InetAddress inetAddress() throws UnknownHostException {
        System.out.println("LiteModeConfig call method...");
        if (flag){
            flag = false;
            return InetAddress.getLocalHost();
        }else{
            return InetAddress.getLoopbackAddress();
        }
    }

    @Bean
    public IP ip() throws UnknownHostException {
        final InetAddress inetAddress = inetAddress();
        return new IP(inetAddress);
    }
}
