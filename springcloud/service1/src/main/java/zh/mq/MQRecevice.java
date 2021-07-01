package zh.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQRecevice {

    @RabbitListener
    @RabbitHandler
    public void recevice(){

    }
}
