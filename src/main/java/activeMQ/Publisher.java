package activeMQ;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * Created by leon on 2017/6/6.
 */
public class Publisher {
    protected static transient ConnectionFactory factory;
    protected static String brokerURL = "tcp://localhost:61616";
    protected transient Connection connection;
    protected transient Session session;

    public Publisher() throws JMSException {
        factory = new ActiveMQConnectionFactory(brokerURL);
        connection = factory.createConnection();
        try {
            connection.start();
        } catch (JMSException e) {
            connection.close();
            throw e;
        }
//        session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE)
    }
}
