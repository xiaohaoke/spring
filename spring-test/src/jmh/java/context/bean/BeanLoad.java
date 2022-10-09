package context.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class BeanLoad {

	public static void main(String[] args) {
		//获取资源
		ClassPathResource resource = new ClassPathResource("config.xml");
		//获取beanFactory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		//根据新建的beanFactory创建一个BeanDefinitionReader对象，该Reader对象为资源的解析器
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		//装载资源 整个过程就分为三个步骤：资源定位、装载、注册
		reader.loadBeanDefinitions(resource);
	}
}
