package cn.argento.askia.awares;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentAwareDemo implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("EnvironmentAwareDemo:" + environment);
    }
}
