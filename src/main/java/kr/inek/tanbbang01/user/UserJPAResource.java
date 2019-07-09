package kr.inek.tanbbang01.user;

import org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// GET /users
	// retrieveAllUsers
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	// GET users/{id}
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent())
			throw new UserNotFoundException("id - " + id);
		
		// "all-users", SERVER_PATH + "/users"
		//HATEOAS
		Resource<User> resource = new Resource<User>(user.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}

	// Created User
	// input - details of user
	// output - created & Return the created URI
	
	//HEATEOAS 
	// Hyper Media as the engine of application state
	@PostMapping("/jpa/users")
	public ResponseEntity<User> creaetUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		// Created
		// /users/${id}
		URI location = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	// GET /jpa/users/{id}/posts
	// retrieveAllUsers
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		Optional<User> userOptional = userRepository.findById(id); 
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id = " + id);
		}
		
		return userOptional.get().getPosts();
	}
	
	// Created Dept
	// input - details of dept
	// output - created & Return the created URI
	
	//HEATEOAS 
	// Hyper Media as the engine of application state
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<User> creaetDept(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) 
			throw new UserNotFoundException("id - " + id);
			
		User user = userOptional.get();
		post.setUser(user);
		postRepository.save(post);
		
		// Created
		// /users/${id}
		URI location = ServletUriComponentsBuilder
											.fromCurrentRequest()
											.path("/{id}")
											.buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
}
