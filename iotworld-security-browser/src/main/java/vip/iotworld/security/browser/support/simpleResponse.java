package vip.iotworld.security.browser.support;

public class simpleResponse {
	
	public simpleResponse(Object content) {
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
