package cn.argentoaskia;

import cn.argentoaskia.beans.Fruit;
import cn.argentoaskia.beans.Generics;
import cn.argentoaskia.beans.GenericsConversion;
import cn.argentoaskia.beans.IP;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
@ComponentScan
public class SpringAnnotationAutowireContext implements ApplicationContextAware {


    @Bean
    public ConversionService conversionService(){
        DefaultFormattingConversionService defaultFormattingConversionService
                = new DefaultFormattingConversionService();
        final GenericsConversion genericsConversion = new GenericsConversion();
        defaultFormattingConversionService.addConverter(genericsConversion);
        return defaultFormattingConversionService;
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

    @Bean
    public IP ip1(){
        IP ip = new IP();
        ip.setHost("Askia");
        ip.setIpStr("192.168.1.1");
        ip.setMark("192.168.1.1");
        return ip;
    }

    @Bean
    public IP ip2(){
        IP ip = new IP();
        ip.setHost("Askia2");
        ip.setIpStr("192.168.1.2");
        ip.setMark("192.168.1.2");
        return ip;
    }

    // 2
    @Bean
    // 值越低，优先级越高,支持负数
    @Order(1)
    public Fruit apple(){
        return Fruit.APPLE;
    }

    // 1
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public Fruit orange(){
        return Fruit.ORANGE;
    }

    // 3
    @Bean
    @Order(5)
    public Fruit pear(){
        return Fruit.PEAR;
    }

    @Bean
    public Set<Float> floatSet(){
        Set<Float> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add((float) Math.random());
        }
        return set;
    }

    @Bean
    public Date date1(){
        return new Date();
    }

    @Bean
    public Date date2(){
        return new Date(2);
    }

    @Bean
    public List<Date> dates(){
        List<Date> dates = new ArrayList<>();
        for (int i = 100; i < 150; i++) {
            final Date date = new Date(i);
            dates.add(date);
        }
        return dates;
    }


    // this show LazyInit Bean

    @Lazy
    @Bean
    public LocalDateTime localDateTime2(){
        return LocalDateTime.now();
    }

    @Bean
    public LocalDateTime localDateTime(){
        return LocalDateTime.now();
    }


    // 泛型内嵌套泛型的情况
    @Bean
    public Generics<String> generics1(){
        return new Generics<String>().setData("123");
    }
    @Bean
    public Generics<String> generics2(){
        return new Generics<String>().setData("456");
    }
    @Bean
    public Generics<String> generics3(){
        return new Generics<String>().setData("789");
    }

    // 该泛型将不会被注入，因为泛型类型不对！
    @Bean
    public Generics<Integer> generics4(){
        return new Generics<Integer>().setData(100);
    }
}
