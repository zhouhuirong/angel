package spring.zhouhr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;
import spring.zhouhr.bean.Person;
import spring.zhouhr.common.MyExclude;

/**
 * 配置类 == 配置文件
 */
@Configuration //告诉spring这是一个配置类
@ComponentScan(value = "spring.zhouhr", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {MyExclude.class, Service.class})}) //扫描包

//@ComponentScan value :指定要扫描的包
//excludeFilters = Filer[], 指定要扫描的时候按什么规则排除那些组件
//includeFilters = Filer[], 指定扫描包的时候只需要包含那些组件
//Jdk1.8 可以有多个ComponentScan
public class MainConfig {

    // 给容器注册一个Bean;类型为返回值的类型；id默认是方法名作为id
    @Bean
    public Person person(){
        return new Person("周辉荣", 18);
    }
}
