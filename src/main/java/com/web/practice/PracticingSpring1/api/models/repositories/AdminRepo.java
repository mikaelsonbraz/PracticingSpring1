package com.web.practice.PracticingSpring1.api.models.repositories;

import com.web.practice.PracticingSpring1.api.models.entities.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepo extends CrudRepository<Admin, Integer> {
}
