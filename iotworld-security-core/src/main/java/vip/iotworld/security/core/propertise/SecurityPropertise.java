package vip.iotworld.security.core.propertise;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "iotworld.security")
public class SecurityPropertise {
	
	private BrowserProperties browserProperties = new BrowserProperties();

	public BrowserProperties getBrowserProperties() {
		return browserProperties;
	}

	public void setBrowserProperties(BrowserProperties browserProperties) {
		this.browserProperties = browserProperties;
	}
	
}
