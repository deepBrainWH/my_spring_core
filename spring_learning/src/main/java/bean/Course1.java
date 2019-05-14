package bean;

import bean.service.UserService;
import bean.service.imp.UserServiceImp;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class Course1 {
	private static Course1 course1 = new Course1();


	public static void main(String[] args) {
		course1.createBean();
	}


	private void createBean() {
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		UserService createBean = (UserService) factory.createBean(UserServiceImp.class);
		createBean.setName("wangheng");
		System.out.println(createBean.getName());
	}

}
