package ru.kdv.study.x6notification.rmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ru.kdv.study.x6notification.model.Order;

@Log4j2
@Component
public class x6notificationConsumer {

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void recive(Order order) {
        log.info(order.toString());
    }
}