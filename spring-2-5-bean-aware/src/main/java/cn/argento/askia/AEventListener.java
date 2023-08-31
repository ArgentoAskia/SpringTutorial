package cn.argento.askia;

import cn.argento.askia.awares.TextEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Deprecated
@Component
public class AEventListener implements ApplicationListener<TextEvent> {


    @Override
    public void onApplicationEvent(TextEvent event) {

    }
}
