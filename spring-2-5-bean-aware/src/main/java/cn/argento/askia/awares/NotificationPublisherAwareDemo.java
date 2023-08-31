package cn.argento.askia.awares;

import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class NotificationPublisherAwareDemo implements NotificationPublisherAware {
    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
    }
}
