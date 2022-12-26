package com.inventory.management.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.inventory.management.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, String> {

}