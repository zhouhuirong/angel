package spring.zhouhr;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.zhouhr.bean.Person;
import spring.zhouhr.config.MainConfig;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);

        Object persion = applicationContext.getBean("person");
        System.out.println(persion);
    }
}
