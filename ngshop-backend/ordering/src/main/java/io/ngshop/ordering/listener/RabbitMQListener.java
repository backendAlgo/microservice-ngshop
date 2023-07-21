package io.ngshop.ordering.listener;

import io.ngshop.ordering.Config;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
//    @Override
//    public void onMessage(Message message) {
//        System.out.println("Consuming Message - " + new String(message.getBody()));
//    }

    @RabbitListener(queues = Config.queueName)
    public void receiveMessage(final Request customMessage) {
        //TODO: yangi xabar kelganda shu method ishlaydi
        // silar demak yangi kelgan xabarni bazalarizga saqlaysilar
        // order uchun Oracle ishlatiladi
        // table structure UserName va order haqida butun ma'lumot bo'ladi
        // Order controllerdagi POST->createOrder logika shu yerda bo'ladi
        // ya'ni queueda yangi xabar bo'lsa controllerga kall qilinmaydi va shu yerda qo'shiladi
        /**
         * public class CheckoutOrderCommand : IRequest<int>
         * {
         *     public string? UserName { get; set; }
         *     public decimal? TotalPrice { get; set; }
         *
         *     public string? FirstName { get; set; }
         *     public string? LastName { get; set; }
         *     public string? EmailAddress { get; set; }
         *     public string? AddressLine { get; set; }
         *     public string? Country { get; set; }
         *     public string? State { get; set; }
         *     public string? ZipCode { get; set; }
         *
         *     public string? CardName { get; set; }
         *     public string? CardNumber { get; set; }
         *     public string? Expiration { get; set; }
         *     public string? CVV { get; set; }
         *     public int? PaymentMethod { get; set; }
         * }
         */
        System.out.println("Received message and deserialized to 'CustomMessage' " + customMessage.toString());
    }
}
