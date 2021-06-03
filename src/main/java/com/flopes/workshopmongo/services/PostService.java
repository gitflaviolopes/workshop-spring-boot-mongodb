package com.flopes.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flopes.workshopmongo.domain.Post;
import com.flopes.workshopmongo.repository.PostRepository;
import com.flopes.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Optional<Post> findById(String id) {
		Optional<Post> post = repository.findById(id);
		if (post == null)
			throw new ObjectNotFoundException("Objeto não encontrado");
		
		return post;
	}
}
