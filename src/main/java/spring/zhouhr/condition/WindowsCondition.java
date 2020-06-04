package spring.zhouhr.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import spring.zhouhr.bean.Person;

/**
 * 判断是否Windows系统
 */
public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        //1、能获取到ioc使用的beanfactory
        ConfigurableListableBeanFactory beanFactory = conditionContext.getBeanFactory();
        //2、获取类加载
        ClassLoader classLoader = conditionContext.getClassLoader();
        //3、获取当前系统环境
        Environment environment = conditionContext.getEnvironment();
        //4、获取bean定义的注册类，此类可以注册、获取、移除bean
        BeanDefinitionRegistry registry = conditionContext.getRegistry();

        String property = environment.getProperty("os.name");
        if (property.contains("Windows")){
            return true;
        }

        return false;
    }
}
