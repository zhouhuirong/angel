package spring.zhouhr.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.zhouhr.config.MainConfig;
import spring.zhouhr.config.MainConfig2;

public class IOCTest {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void testImport(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
        Object colorFactoryBean = context.getBean("colorFactoryBean");
        Object colorFactoryBean1 = context.getBean("colorFactoryBean");
        System.out.println(colorFactoryBean.getClass());
        System.out.println(colorFactoryBean == colorFactoryBean1);
    }
    @Test
    public void test03(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
    }
    @Test
    public void test02(){
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
        Object person = context.getBean("person");
        Object person2 = context.getBean("person");
        System.out.println(person == person2);
    }
    @Test
    public void test01(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
    }

}
