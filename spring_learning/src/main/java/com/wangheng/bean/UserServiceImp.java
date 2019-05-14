package com.wangheng.bean;


public class UserServiceImp implements UserService {

//	@Autowired
	private UserDao userDao;

	public UserServiceImp(){
		System.out.println("创建bean");
	}

	@Override
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "111111";
	}

	@Override
	public UserDao getUserDao() {
		return this.userDao;
	}

}
