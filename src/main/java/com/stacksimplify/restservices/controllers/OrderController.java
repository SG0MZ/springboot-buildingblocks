package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	//getAllOrders for a user
	@GetMapping("/{userId}/orders")
	public List<Order> getAllOrders(@PathVariable Long userId) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		return userOptional.get().getOrders();
	}
	
	//Create Order
	@PostMapping("/{userId}/orders")
	public Order createOrder(@PathVariable Long userId,@RequestBody Order order) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		User user = userOptional.get();
		order.setUser(user);
		return orderRepository.save(order);
	}
	
	//getOrderByOrderId
	@GetMapping("/{userId}/orders/{orderId}")
	public Optional<Order> getOrderByOrderId(@PathVariable Long userId,@PathVariable Long orderId) throws UserNotFoundException {
		Optional<User> userOptional = userRepository.findById(userId);
		if(!userOptional.isPresent())
			throw new UserNotFoundException("User Not Found");
		
		Optional<Order> orderOptional = orderRepository.findById(orderId);
		if(!orderOptional.isPresent())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Not Found in Order Repository, provide the correct order id");

		return orderOptional;
		
	}
}
