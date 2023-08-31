package cn.argentoaskia.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * DependsOn Bean演示，容器内没有localDateTime名字的bean则没有LocalDateTimeDependOnBean对象
 */
@Component
@DependsOn("localDateTime")
public class LocalDateTimeDependOnBean {
    private LocalDateTime localDateTime;

    @Autowired
    public LocalDateTimeDependOnBean(@Qualifier("localDateTime")LocalDateTime dateTime){
        this.localDateTime = dateTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("LocalDateTimeDependOnBean{");
        sb.append("localDateTime=").append(localDateTime);
        sb.append('}');
        return sb.toString();
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public LocalDateTimeDependOnBean setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }
}
