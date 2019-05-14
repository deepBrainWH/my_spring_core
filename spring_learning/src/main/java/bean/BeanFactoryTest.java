package bean;

import org.junit.Test;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.util.Assert;

public class BeanFactoryTest {
	private static BeanFactoryTest beanFactoryTest = new BeanFactoryTest();


	public static void main(String[] args) {
//		beanFactoryTest.createBean();
//		beanFactoryTest.beanSorre();
//		beanFactoryTest.dependencyTest();
//		beanFactoryTest.dependencyTest1();
		beanFactoryTest.dependencyTest2();
//		beanFactoryTest.getBeanTest();


	}

	/**
	 * 创建Bean
	 */
	private void createBean() {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		UserServiceImp bean = factory.createBean(UserServiceImp.class);
		System.out.println(bean.getName());
	}

	/**
	 * Bean 存储
	 */
	private void beanSorre(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		factory.registerSingleton("userDao", new UserDaoImp());
		UserDao userDao = (UserDao)factory.getBean("userDao");
		System.out.println(userDao);
	}

	/**
	 * 依赖关系注入 (失败案例）
	 */
	private void dependencyTest(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		UserServiceImp bean = (UserServiceImp)factory.createBean(UserServiceImp.class,
				AbstractBeanDefinition.AUTOWIRE_BY_TYPE, true);
		System.out.println(bean);
	}

	/**
	 * 依赖关系注入 (成功案例-1）
	 */
	private void dependencyTest1(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		UserServiceImp bean = (UserServiceImp)factory.createBean(UserServiceImp.class,
				AbstractBeanDefinition.AUTOWIRE_BY_TYPE, false);
		System.out.println(bean);
	}

	/**
	 * 依赖关系注入（成功案例2， 手动创建依赖bean)
	 */
	private void dependencyTest2(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		factory.registerSingleton("dao1", new UserDaoImp());
		UserServiceImp bean = (UserServiceImp)factory.createBean(UserServiceImp.class,
				AbstractBeanDefinition.AUTOWIRE_BY_TYPE, true);
		System.out.println(bean);
	}

	private void getBeanTest(){
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
		xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

		UserServiceImp bean = factory.getBean(UserServiceImp.class);
		Assert.notNull(bean, "Bean not  null");
		System.out.println(bean.getUserDao());

	}

}
