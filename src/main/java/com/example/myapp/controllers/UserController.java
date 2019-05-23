package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.Role;
import com.example.myapp.models.User;

@RestController
public class UserController {
	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(123, "alice", "Alice", "dssagf", "dan", Role.ADMIN));
		users.add(new User(234, "bob", "Bob", "sjdss", "bad", Role.FACULTY));
		users.add(new User(345, "charlie", "Charlie", "dsjhk", "can", Role.FACULTY));
		users.add(new User(456, "dan", "Dan", "skgjlkj", "cad", Role.ADMIN));
	}
	// CRUD
// POST - Creating
	@PostMapping("/users")
	public List<User> createUser(@RequestBody User user) {
		users.add(user);
		return users;
	}

	// GET - Reading
	@GetMapping("/users")
	public List<User> findAllUsers() {

		return users;
	}


	@GetMapping("/users/{id}")
	public User findUserById(@PathVariable("id") long id) {

		for (User eachUser: users){
			if(eachUser.getId() == id){
				return eachUser;
			}
		}
		return null;
	}

	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable("id") long id, @RequestBody User user){

		for(User eachUser : users){
			if(eachUser.getId() == id){
				eachUser.setUsername(user.getUsername());
				eachUser.setFirstName(user.getFirstName());
				eachUser.setLastname(user.getLastName());
				eachUser.setPassword(user.getPassword());
				eachUser.setRole(user.getRole());
				break;
			}
		}
//		return users;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") long id){

		User temp  = null;
		for(User eachUser : users){
			if(eachUser.getId() == id){

				temp = eachUser;
				break;
			}
		}
		users.remove(temp);
//		return users;
	}
}
