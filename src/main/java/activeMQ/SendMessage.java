package activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by leon on 2017/6/6.
 */
public class SendMessage {
    private static final String url ="tcp://localhost:61616";
    private static final String QUEUE_NAME ="choice.queue23";
    protected String expectedBody = "<hello>world!</hello>";
    public void sendMessage() throws JMSException {
        Connection connection =null;
        try{
            ActiveMQConnectionFactory connectionFactory =new ActiveMQConnectionFactory(url);
            connection = (Connection)connectionFactory.createConnection();
            connection.start();
            Session session = (Session)connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(QUEUE_NAME);
            MessageProducer producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage(expectedBody);
            message.setStringProperty("headname", "remoteB");
            producer.send(message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SendMessage sndMsg = new SendMessage();
        try{
            sndMsg.sendMessage();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
