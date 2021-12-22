package com.bridgelabz.greeting.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}