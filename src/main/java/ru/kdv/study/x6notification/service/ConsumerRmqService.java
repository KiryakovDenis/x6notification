package ru.kdv.study.x6notification.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.kdv.study.x6notification.model.Order;

@Log4j2
@Service
public class ConsumerRmqService {

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void recive(Order order) {
        log.info(order.toString());
    }
}