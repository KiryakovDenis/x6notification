package ru.kdv.study.x6notification.rmq;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class x6notificationConsumer {

    /**TODO: Каким то образом нужно научиться получать POJO класс
     * в текущей реализации валятся ошибки десериализации (если внаглую попытаться извлечь класс из очереди)
     * елси использовать MessageConverter ругается на всякие символы непонятной кодировки
     * */
    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void recive(String message) {
        log.info(message);
    }

}
