package spring.zhouhr.controller;

import org.springframework.stereotype.Controller;
import spring.zhouhr.common.MyExclude;

/**
 * 各种注入注解
 * @Controller  用于标注控制层，相当于struts中的action层
 * @Service  用于标注服务层，主要用来进行业务的逻辑处理
 * @Repository 用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件
 *@Component  泛指各种组件，就是说当我们的类不属于各种归类的时候
 *
 */
@MyExclude
@Controller
public class BookController {
}
