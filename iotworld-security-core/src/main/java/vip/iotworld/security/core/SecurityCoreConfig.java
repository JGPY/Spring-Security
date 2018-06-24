package vip.iotworld.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import vip.iotworld.security.core.propertise.SecurityPropertise;

@Configuration
@EnableConfigurationProperties(SecurityPropertise.class)
public class SecurityCoreConfig {

}
