package cn.argento.askia.awares.context;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceAwareDemo implements MessageSourceAware {
    @Override
    public void setMessageSource(MessageSource messageSource) {

    }
}
