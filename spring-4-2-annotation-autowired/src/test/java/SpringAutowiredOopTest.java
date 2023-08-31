import cn.argento.askia.SpringAutowiredOopContext;
import cn.argento.askia.beans2.Employee2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Set;

public class SpringAutowiredOopTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringAutowiredOopContext.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name :
                beanDefinitionNames) {
            Object bean = annotationConfigApplicationContext.getBean(name);
            System.out.println(name + " : " + bean);
        }
        System.out.println();
        System.out.println("================================================");
        System.out.println();
        final Map<String, Employee2> employeeMap = annotationConfigApplicationContext.getBeansOfType(Employee2.class);
        final Set<String> set = employeeMap.keySet();
        for (String key :
                set) {
            final Employee2 employee = employeeMap.get(key);
            System.out.println(key + " : " + employee);
        }

    }
}
