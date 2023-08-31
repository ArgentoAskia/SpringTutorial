package cn.argentoaskia.context;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class LifeCycleCallbackB implements SmartLifecycle {

    private volatile boolean running = false;

    @Override
    public void start() {
        System.out.println("=========== LifeCycleCallbackB ===========");
        System.out.println("容器已启动完毕....");
        System.out.println("当前时间为" + LocalDateTime.now());
        running = true;
        System.out.println("=========== LifeCycleCallbackB ===========");
    }

    /**
     * 让这个cycle早点运行
     * @return
     */
    @Override
    public int getPhase() {
        return 1;
    }

    @Override
    public void stop() {
        System.out.println("=========== LifeCycleCallbackB ===========");
        System.out.println("容器即将销毁....");
        System.out.println("当前时间为" + LocalDateTime.now());
        System.out.println("=========== LifeCycleCallbackB ===========");
        running = false;
    }

    @Override
    public boolean isRunning() {
        System.out.println("LifeCycleCallbackB是否在运行" + running);
        return running;
    }
}
