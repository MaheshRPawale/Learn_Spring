package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
@Service
public class UserService {
    
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    // CREATE
    public UserResponseDto createUser(UserRequestDto userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setCity(userDTO.getCity());

        User savedUser = userRepository.save(user);

        if(userDTO.getPosts() != null) {
            List<Post> posts = userDTO.getPosts().stream().map(postDto -> {
                Post post = new Post();
                post.setTitle(postDto.getTitle());
                post.setContent(postDto.getContent());
                post.setUser(savedUser);
                return postRepository.save(post);
            }).collect(Collectors.toList());
            
            savedUser.setPosts(posts);
        }

        return mapToUserResponseDto(savedUser);
    }

    // GET ALL
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToUserResponseDto)
                .collect(Collectors.toList());
    }

    // GET BY ID
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return mapToUserResponseDto(user);
    }

    // UPDATE
    public UserResponseDto updateUser(Long id, UserRequestDto userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setCity(userDTO.getCity());
        
        User updatedUser = userRepository.save(user);
        return mapToUserResponseDto(updatedUser);
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Helper method for mapping
    private UserResponseDto mapToUserResponseDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setName(user.getName());
        responseDto.setEmail(user.getEmail());
        responseDto.setCity(user.getCity());
        
        if(user.getPosts() != null) {
            List<PostDto> postDtos = user.getPosts().stream()
                    .map(this::mapToPostDto)
                    .collect(Collectors.toList());
            responseDto.setPosts(postDtos);
        }
        
        return responseDto;
    }

    private PostDto mapToPostDto(Post post) {
        PostDto dto = new PostDto();
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        return dto;
    }
}