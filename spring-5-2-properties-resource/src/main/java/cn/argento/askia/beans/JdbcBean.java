package cn.argento.askia.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.URI;

// @Configuration VS @Component
@Component("jdbcBean2")
@PropertySource("classpath:jdbc.properties")
public class JdbcBean {

    @Bean
    public URI uri2(@Value("${url}") String url){
        return URI.create(url);
    }

    @Value("${className}")
    private String className;
    @Value("${username}")
    private String username;
    @Autowired
    @Qualifier("uri2")
    private URI url;
    @Value("${password}")
    private String password;
    @Value("${timeout}")
    private int timeout;
    @Value("${maxActive}")
    private int maxActive;
    @Value("${minActive}")
    private int minActive;
    @Value("${maxMemory}")
    private String maxMemory;
    @Value("${application.name}")
    private String applicationName;
    @Value("${application.port}")
    private long applicationPort;
    @Value("${application.description}")
    private String applicationDescription;


    public String getClassName() {
        return className;
    }

    public JdbcBean setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public JdbcBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public URI getUrl() {
        return url;
    }

    public JdbcBean setUrl(URI url) {
        this.url = url;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JdbcBean setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getTimeout() {
        return timeout;
    }

    public JdbcBean setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public int getMaxActive() {
        return maxActive;
    }

    public JdbcBean setMaxActive(int maxActive) {
        this.maxActive = maxActive;
        return this;
    }

    public int getMinActive() {
        return minActive;
    }

    public JdbcBean setMinActive(int minActive) {
        this.minActive = minActive;
        return this;
    }

    public String getMaxMemory() {
        return maxMemory;
    }

    public JdbcBean setMaxMemory(String maxMemory) {
        this.maxMemory = maxMemory;
        return this;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public JdbcBean setApplicationName(String applicationName) {
        this.applicationName = applicationName;
        return this;
    }

    public long getApplicationPort() {
        return applicationPort;
    }

    public JdbcBean setApplicationPort(long applicationPort) {
        this.applicationPort = applicationPort;
        return this;
    }

    public String getApplicationDescription() {
        return applicationDescription;
    }

    public JdbcBean setApplicationDescription(String applicationDescription) {
        this.applicationDescription = applicationDescription;
        return this;
    }

    public JdbcBean() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JdbcBean{");
        sb.append("className='").append(className).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", url=").append(url);
        sb.append(", password='").append(password).append('\'');
        sb.append(", timeout=").append(timeout);
        sb.append(", maxActive=").append(maxActive);
        sb.append(", minActive=").append(minActive);
        sb.append(", maxMemory='").append(maxMemory).append('\'');
        sb.append(", applicationName='").append(applicationName).append('\'');
        sb.append(", applicationPort=").append(applicationPort);
        sb.append(", applicationDescription='").append(applicationDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public JdbcBean(String className, String username, URI url, String password, int timeout, int maxActive, int minActive, String maxMemory, String applicationName, long applicationPort, String applicationDescription) {
        this.className = className;
        this.username = username;
        this.url = url;
        this.password = password;
        this.timeout = timeout;
        this.maxActive = maxActive;
        this.minActive = minActive;
        this.maxMemory = maxMemory;
        this.applicationName = applicationName;
        this.applicationPort = applicationPort;
        this.applicationDescription = applicationDescription;
    }
}
