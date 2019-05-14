package com.wangheng.bean.course1;

import com.wangheng.bean.course1.service.UserService;
import com.wangheng.bean.course1.service.imp.UserServiceImp;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class Learning1 {
    @Test
    public void createBean(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();

        UserService bean = factory.createBean(UserServiceImp.class);

        bean.setName("hello world");

        System.out.println(bean.getName());
    }

    @Test
    public void beanStore(){
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("service", new UserServiceImp());
        UserService service = (UserService)factory.getBean("service");
        service.setName("wangheng");
        System.out.println(service.getName());
    }


}
