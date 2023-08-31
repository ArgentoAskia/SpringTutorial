package cn.argento.askia.awares.context;

import cn.argento.askia.awares.TextEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Deprecated
@Component
public class ApplicationEventPublisherAwareDemo implements ApplicationEventPublisherAware {
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        TextEvent textEvent = new TextEvent("123");
        applicationEventPublisher.publishEvent(textEvent);
    }
}
