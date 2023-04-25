package context.context;

/**
 * @author xiaohaoke
 */
@MyService
public class MyAnnoClass {
	public String username = "xiaoxizi";

	public MyAnnoClass(String username) {
		this.username = username;
	}

	public MyAnnoClass() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}