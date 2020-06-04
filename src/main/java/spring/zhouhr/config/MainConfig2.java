package spring.zhouhr.config;

import org.springframework.context.annotation.*;
import spring.zhouhr.bean.Color;
import spring.zhouhr.bean.ColorFactoryBean;
import spring.zhouhr.bean.Person;
import spring.zhouhr.bean.Red;
import spring.zhouhr.condition.LinuxCondition;
import spring.zhouhr.condition.WindowsCondition;

@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class, Red.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig2 {

    /**
     * Scope
     * prototype；多实例 ；ioc容器启动并不会调用方法创建对象放到容器中，
     *                      每次获取的时候才调用方法创建对象。
     * singleton；单实例（默认值）；ioc容器启动会调用方法创建对象放到ioc容器
     *              以后每次获取就直接从容器（map.get()）中获取。
     * request ；同一次请求创建一个实例
     * session ；同一个session创建一个实例
     *
     *
     *  Lazy 懒加载：单实例bean,默认在容器启动时创建对象；（只针对单实例模式）
     *          懒加载，容器启动时不创建对象，第一次使用（获取）Bean创建对象，并初始化
     * @return
     */
    @Scope
    @Lazy
    @Bean
    public Person person(){
        return new Person("周辉荣",22);
    }

    /**
     * Conditional；按照一定的条件进行判断，满足条件给容器中注册bean
     * 放在方法上：满足当前条件注册bean
     * 放在类上：满足当前条件，这个类中配置的所有bean才能生效
     * 方法上优先级高于类
     * @return
     */
    @Conditional({WindowsCondition.class})
    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates", 66);
    }
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 46);
    }

    /**
     * 给容器中注册组件：
     * 1）、包扫描+组件标注注解（@Controller @Service @Repository @Compoent）
     * 2) 、@Bean[导入的第三方包里面的组件]
     * 3）、@Import[快速给容器中导入一个组件],id默认是组件的全类名
     *      a)、@Import({要导入到容器中的组件})；容器中就会自动注册这样组件，id默认是全类名
     *      b)、ImportSelector;创建一个类实现ImportSelector接口中selectImports方法，
     *          然后把实现类加入@Import 数组中
     *      c）、ImportBeanDefinitionRegistrat 手动注册bean到容器中
     * 4）、使用spring提供的FactoryBean(工厂bean)
     *
     */
    @Bean
    public ColorFactoryBean colorFactoryBean(){
        return new ColorFactoryBean();
    }
}
