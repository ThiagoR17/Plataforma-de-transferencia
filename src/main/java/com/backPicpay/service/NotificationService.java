package com.backPicpay.service;

import com.backPicpay.DTO.NotificationDTO;
import com.backPicpay.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationDTO = new NotificationDTO(email, message);

        //ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationDTO, String.class);

        //if (notificationResponse.getStatusCode() != HttpStatus.OK) {
          //  System.out.println("Erro ao enviar notificação");
           // throw new Exception("Serviço de notificação fora do ar!");
       // }

        System.out.println("Notificação enviada para o usuario");
    }
}
