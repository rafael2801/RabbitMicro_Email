package com.ms.email.consumers;

import com.ms.email.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listenEmailQueue(@Payload EmailDto emailRecordDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDto, emailModel);
        this.emailService.sendEmail(emailModel);
    }
}
