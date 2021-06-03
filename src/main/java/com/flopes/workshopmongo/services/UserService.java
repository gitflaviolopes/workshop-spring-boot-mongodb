package com.flopes.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flopes.workshopmongo.domain.User;
import com.flopes.workshopmongo.dto.UserDTO;
import com.flopes.workshopmongo.repository.UserRepository;
import com.flopes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public User insert(User obj) {
		return repository.insert(obj);
	}

	public User fromDto(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
}
