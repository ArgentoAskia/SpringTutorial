import cn.argentoaskia.SpringAutowiredTypeContext;
import cn.argentoaskia.beans.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Set;

public class SpringAutowiredTypeTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(SpringAutowiredTypeContext.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name :
                beanDefinitionNames) {
            Object bean = annotationConfigApplicationContext.getBean(name);
            System.out.println(name + " : " + bean);
        }
        System.out.println();
        System.out.println("================================================");
        System.out.println();
        final Map<String, Employee> employeeMap = annotationConfigApplicationContext.getBeansOfType(Employee.class);
        final Set<String> set = employeeMap.keySet();
        for (String key :
                set) {
            final Employee employee = employeeMap.get(key);
            System.out.println(key + " : " + employee);
        }

    }
}
