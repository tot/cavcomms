package cavbotics.ntclient.api;

public class Greetings {

	private long id = 0;
	private String content = "";

	public Greetings(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}