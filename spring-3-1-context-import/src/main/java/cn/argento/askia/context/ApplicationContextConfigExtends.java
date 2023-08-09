package cn.argento.askia.context;


import cn.argento.askia.beans.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ApplicationContextConfig.class)
public class ApplicationContextConfigExtends {

    @Bean
    public TestBean testBean(){
        return new TestBean("Askia2", 30);
    }
}
