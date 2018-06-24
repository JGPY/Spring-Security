/**
 * 
 */
package vip.iotworld.service.impl;

import org.springframework.stereotype.Service;

/**
 * @author liubing
 *
 */
@Service
public class HelloService implements vip.iotworld.service.HelloService {
	@Override
	public String greeting(String name) {
		System.out.println("greeting");
		return "hello"+name;
	}

}
