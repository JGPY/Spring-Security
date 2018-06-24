/**
 * 
 */
package vip.iotworld.web.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import vip.iotworld.dto.User;
import vip.iotworld.dto.UserQueryCondition;

/**
 * @author liubing
 *
 */
@RestController
@RequestMapping("/user")
public class UserController{
	
	@PostMapping
	public User create(@Valid @RequestBody User user, BindingResult erros) {
		if (erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(error -> {
//			FieldError	fieldError = (FieldError) error;
//			String message = fieldError.getField() +" "+ error.getDefaultMessage();
//			System.out.println(message);
			System.out.println(error.getDefaultMessage());
			}
			);
		}
		
		System.out.println(user.getUsername());
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}
	
//	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@GetMapping
	@JsonView(User.UserSimpleView.class)
	public List<User> query(UserQueryCondition nikenamen, @PageableDefault(page=2, size=17, sort="username.asc") Pageable pageable){
		List<User> users = new ArrayList<User>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;	
	}

	
//	@RequestMapping(value = "/user/{id:\\d+}", method = RequestMethod.GET)
	@GetMapping(value = "/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User getInfo(@PathVariable(name = "id") String idxxx) {
		
//		throw new UserNotExistException(idxxx);
		System.out.println("����getInfo����");
		User user = new User();
		user.setUsername("tom");
		return user;
	}
	
	@PutMapping(value = "/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public User update(@Valid @RequestBody User user, BindingResult erros) {
		if (erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(error -> System.out.println(error.getDefaultMessage()));
		}
		
		System.out.println(user.getUsername());
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		
		user.setId("1");
		return user;
	}
	
	@DeleteMapping("/{id:\\d+}")
	@JsonView(User.UserDetailView.class)
	public void delete(@PathVariable String id) {
		System.out.println(id);
	}
	
}
