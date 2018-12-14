package in.tcampus.model;

public class WelcomeMessageBean {

	private String message;

	public WelcomeMessageBean(){
		message="Welcome...";
	}
	
	public WelcomeMessageBean(String message) {
		super();
		this.message = message;
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "WelcomeMessageBean [message=" + message + "]";
	}
	
	
	
}
