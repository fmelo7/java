package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.Message;

@RepositoryRestResource
public interface MessageResource extends JpaRepository<Message, Long> {

}
