package com.hdy.jpa.controller;

import com.hdy.jpa.entity.Users;
import com.hdy.jpa.exception.CustomException;
import com.hdy.jpa.exception.ErrorCode;
import com.hdy.jpa.repository.UsersRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController // will be written straight into the response body
public class UsersController {
    private UsersRepository usersRepository;

    UsersController(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @GetMapping("/users")
    CollectionModel<EntityModel<Users>> all() {

        List<EntityModel<Users>> users = usersRepository.findAll().stream()
                .map(user -> EntityModel.of(user,
                        linkTo(methodOn(UsersController.class).one(user.getId())).withSelfRel(),
                        linkTo(methodOn(UsersController.class).all()).withRel("users")))
                .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UsersController.class).all()).withSelfRel());
    }

    @GetMapping("/users/{id}")
    EntityModel<Users> one(@PathVariable Long id) {

        Users users = usersRepository.findById(id) //
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NOT_FOUND));

        return EntityModel.of(users, //
                linkTo(methodOn(UsersController.class).one(id)).withSelfRel(),
                linkTo(methodOn(UsersController.class).all()).withRel("users"));
    }
}
