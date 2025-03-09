package com.msobservabilite.microservice_observabilite_user.service;

import com.msobservabilite.microservice_observabilite_user.model.UserModel;
import com.msobservabilite.microservice_observabilite_user.producer.UserProducer;
import com.msobservabilite.microservice_observabilite_user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer){
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;

    }
}
