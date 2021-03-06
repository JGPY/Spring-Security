/**
 * 
 */
package vip.iotworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liubing
 *
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@RestController
public class DemoApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	@GetMapping("/hello")
	public String hello() {
		return "hello spring security";
	}
}
