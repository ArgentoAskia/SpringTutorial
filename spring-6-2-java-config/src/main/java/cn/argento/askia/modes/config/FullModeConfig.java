package cn.argento.askia.modes.config;


import cn.argento.askia.modes.beans.IP;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

// ref;https://zhuanlan.zhihu.com/p/616480632
// Full模式下我们只看到输出了一次信息（初始化InetAddress时调用了一次方法）
// 在初始化IP类的时候，不会输出信息，因为inetAddress2()被CGlib代理了
// 调用该方法不会执行方法体，而是直接从容器中拿到之前创建的inetAddress2()对象
// 相当于调用容器的getBean()
@Configuration
@ComponentScan("cn.argento.askia.modes.beans")
public class FullModeConfig {

    private static boolean flag = true;

    @Bean
    public InetAddress inetAddress2() throws UnknownHostException {
        System.out.println("FullModeConfig call method...");
        if (flag){
            flag = false;
            return InetAddress.getLocalHost();
        }else{
            return InetAddress.getLoopbackAddress();
        }
    }

    @Bean
    public IP ip2() throws UnknownHostException {
        final InetAddress inetAddress = inetAddress2();
        return new IP(inetAddress);
    }
}
