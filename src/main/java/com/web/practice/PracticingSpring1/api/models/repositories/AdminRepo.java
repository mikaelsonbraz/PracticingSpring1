package com.web.practice.PracticingSpring1.api.models.repositories;

import com.web.practice.PracticingSpring1.api.models.entities.Admin;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Integer> {

    @Query(value = "SELECT * from admin WHERE email = :email and password = :password", nativeQuery = true)
    public Admin validation(String email, String password);
}
