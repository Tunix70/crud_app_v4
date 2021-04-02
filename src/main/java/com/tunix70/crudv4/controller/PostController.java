package com.tunix70.crudv4.controller;

import com.tunix70.crudv4.model.Post;
import com.tunix70.crudv4.repository.JDBC.JDBCPostRepositoryImpl;
import com.tunix70.crudv4.repository.PostRepository;


import java.util.List;

public class PostController {
    private PostRepository postRepository = new JDBCPostRepositoryImpl();

    public List<Post> getAll(){
        return postRepository.getAll();
    }
    public Post getById(Long id){
        return postRepository.getById(id);
    }
    public Post save(Post post){
        return postRepository.save(post);
    }
    public Post update(Post post){
        return postRepository.update(post);
    }
    public void deleteById(Long id){
        postRepository.deleteById(id);
    }

}
