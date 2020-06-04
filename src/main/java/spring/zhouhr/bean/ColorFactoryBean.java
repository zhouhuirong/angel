package spring.zhouhr.bean;

import org.springframework.beans.factory.FactoryBean;

/**
 * 创建一个sprig定义的FactoryBean
 */
public class ColorFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个Color对象，这个对象会添加到容器中
     * @return
     * @throws Exception
     */
    public Color getObject() throws Exception {
        System.out.println("crean color ....");
        return new Color();
    }

    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 是否单实例
     * true，这个bean是单实例，在容器中保存一份
     * false，这个bean是多例，每次获取会创建一个新的
     * @return
     */
    public boolean isSingleton() {
        return true;
    }
}
