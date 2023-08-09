package cn.argento.askia.context;

import cn.argento.askia.beans.DerivedTestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import java.net.InetAddress;
import java.time.LocalDateTime;

@Configuration
@ImportResource("classpath:spring-context-import.xml")
public class ApplicationContextConfig {

    @Bean
    public DerivedTestBean testBean(){
        return (DerivedTestBean) new DerivedTestBean().setAddress("USA").setAge(20).setName("Askia");
    }

    @Bean
    @Autowired
    public StringBuilder testBuilder(LocalDateTime localDateTime, InetAddress inetAddress){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(localDateTime).append("=").append(inetAddress);
        return stringBuilder;
    }

}
