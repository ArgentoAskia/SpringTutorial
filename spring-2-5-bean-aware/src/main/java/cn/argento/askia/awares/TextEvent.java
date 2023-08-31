package cn.argento.askia.awares;

import org.springframework.context.ApplicationEvent;

@Deprecated
public class TextEvent extends ApplicationEvent {
    private String message;

    public TextEvent(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
