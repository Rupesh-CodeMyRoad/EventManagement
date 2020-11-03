package com.broadway.eventmanagement.repo;


import com.broadway.eventmanagement.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserTypeRepository extends JpaRepository<UserType, Integer> {

}