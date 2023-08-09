package cn.argento.askia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.net.URI;

@Configuration
@ComponentScan
@PropertySource(value = "classpath:log4j.properties")
// Springboot提供了更加便捷的注解：@ConfigurationProperties
public class SpringConfig {
    @Value("${log4j.rootLogger}")
    private String rootLogger;
    @Value("${log4j.logger.cn.argentoaskia.dao}")
    private String logger;
    @Value("${log4j.appender.stdout}")
    private String appenderStdout;
    @Value("${log4j.appender.stdout.layout}")
    private String appenderStdoutLayout;
    @Value("${log4j.appender.stdout.layout.ConversionPattern}")
    private String appenderStdoutLayoutConversionPattern;

    // 另外一种更加原始的方式
    @Autowired
    private Environment environment;

    public void printEnvs(){
        String property = environment.getProperty("log4j.rootLogger");
        String property2 = environment.getProperty("log4j.logger.cn.argentoaskia.dao");
        System.out.println("log4j.rootLogger = " + property);
        System.out.println("log4j.logger.cn.argentoaskia.dao = " + property2);

    }


    public String getRootLogger() {
        return rootLogger;
    }

    public SpringConfig setRootLogger(String rootLogger) {
        this.rootLogger = rootLogger;
        return this;
    }

    public String getLogger() {
        return logger;
    }

    public SpringConfig setLogger(String logger) {
        this.logger = logger;
        return this;
    }

    public String getAppenderStdout() {
        return appenderStdout;
    }

    public SpringConfig setAppenderStdout(String appenderStdout) {
        this.appenderStdout = appenderStdout;
        return this;
    }

    public String getAppenderStdoutLayout() {
        return appenderStdoutLayout;
    }

    public SpringConfig setAppenderStdoutLayout(String appenderStdoutLayout) {
        this.appenderStdoutLayout = appenderStdoutLayout;
        return this;
    }

    public String getAppenderStdoutLayoutConversionPattern() {
        return appenderStdoutLayoutConversionPattern;
    }

    public SpringConfig setAppenderStdoutLayoutConversionPattern(String appenderStdoutLayoutConversionPattern) {
        this.appenderStdoutLayoutConversionPattern = appenderStdoutLayoutConversionPattern;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SpringConfig{");
        sb.append("rootLogger='").append(rootLogger).append('\'');
        sb.append(", logger='").append(logger).append('\'');
        sb.append(", appenderStdout='").append(appenderStdout).append('\'');
        sb.append(", appenderStdoutLayout='").append(appenderStdoutLayout).append('\'');
        sb.append(", appenderStdoutLayoutConversionPattern='").append(appenderStdoutLayoutConversionPattern).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
