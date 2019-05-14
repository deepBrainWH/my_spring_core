package bean.service.imp;


import bean.service.UserService;

public class UserServiceImp implements UserService {

	private String name;
	
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
