package cn.argento.askia.beans;

import java.net.URI;

public class JdbcExtendsBean extends JdbcBean{
    private String customStrategyClass;
    private String driverMysql;

    public JdbcExtendsBean() {
    }

    public JdbcExtendsBean(String customStrategyClass, String driverMysql) {
        this.customStrategyClass = customStrategyClass;
        this.driverMysql = driverMysql;
    }

    public JdbcExtendsBean(String className, String username, URI url, String password, int timeout, int maxActive, int minActive, String maxMemory, String applicationName, long applicationPort, String applicationDescription, String customStrategyClass, String driverMysql) {
        super(className, username, url, password, timeout, maxActive, minActive, maxMemory, applicationName, applicationPort, applicationDescription);
        this.customStrategyClass = customStrategyClass;
        this.driverMysql = driverMysql;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("JdbcExtendsBean{");
        sb.append(super.toString()).append(", ");
        sb.append("customStrategyClass='").append(customStrategyClass).append('\'');
        sb.append(", driverMysql='").append(driverMysql).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getCustomStrategyClass() {
        return customStrategyClass;
    }

    public JdbcExtendsBean setCustomStrategyClass(String customStrategyClass) {
        this.customStrategyClass = customStrategyClass;
        return this;
    }

    public String getDriverMysql() {
        return driverMysql;
    }

    public JdbcExtendsBean setDriverMysql(String driverMysql) {
        this.driverMysql = driverMysql;
        return this;
    }
}
