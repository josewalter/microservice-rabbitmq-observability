package com.msobservabilite.microservice_observabilite_user.repository;

import com.msobservabilite.microservice_observabilite_user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
