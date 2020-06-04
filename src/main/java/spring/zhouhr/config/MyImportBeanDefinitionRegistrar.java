package spring.zhouhr.config;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import spring.zhouhr.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     *
     * @param annotationMetadata 当前类的注解信息
     * @param beanDefinitionRegistry BeanDefinition注册类
     *                   把所有需要添加到容器中的bean,调用
     *                   BeanDefinitionRegistry.registerBeanDefinition 手动注册进来
     */
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean red = beanDefinitionRegistry.containsBeanDefinition("spring.zhouhr.bean.Red");
        if (red){
            //指定Bean定义信息
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            // 注册一个Bean,指定bean名
            beanDefinitionRegistry.registerBeanDefinition("rainBow",beanDefinition);
        }
    }
}
