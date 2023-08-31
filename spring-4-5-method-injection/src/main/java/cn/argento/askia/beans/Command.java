package cn.argento.askia.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Command {
    private String uuid;
    private Object status;



    public Object execute(Object commandState){
        setStatus(commandState);
        setUuid(UUID.randomUUID().toString());
        return uuid + "#" + status;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Command{");
        sb.append("uuid='").append(uuid).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getUuid() {
        return uuid;
    }

    public Command setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public Object getStatus() {
        return status;
    }

    public Command setStatus(Object status) {
        this.status = status;
        return this;
    }
}
