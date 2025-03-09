package com.msobservabilite.microservice_observabilite_user.producer;

import com.msobservabilite.microservice_observabilite_user.dto.EmailDto;
import com.msobservabilite.microservice_observabilite_user.model.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingkey;

    public void publishMessageEmail(UserModel userModel) {
        var emalDto = new EmailDto();
        emalDto.setUserId(userModel.getUserId());
        emalDto.setEmailTo(userModel.getEmail());
        emalDto.setSubject("Email cadastrado com sucesso!");
        emalDto.setText(userModel.getName() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!   ");

        rabbitTemplate.convertAndSend("", routingkey, emalDto);
    }
}
