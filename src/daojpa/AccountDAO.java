package daojpa;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	public void justASysout() {
		System.out.println("hello I am a sysout!");
	}
}
