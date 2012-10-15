package org.marianoguerra.jms

import java.util.Properties

import javax.jms.Connection
import javax.jms.ConnectionFactory
import javax.jms.MessageConsumer
import javax.jms.MessageProducer
import javax.jms.Session
import javax.jms.TextMessage
import javax.jms.Topic
import javax.naming.InitialContext

class TopicExample {

   def getContext(): InitialContext = {
      val props = new Properties()

      props.setProperty("java.naming.factory.initial",
        "org.jnp.interfaces.NamingContextFactory")
      props.setProperty("java.naming.provider.url", "jnp://localhost:1099")
      props.setProperty("java.naming.factory.url.pkgs",
        "org.jboss.naming:org.jnp.interfaces")

      new InitialContext(props)
   }

   def run() {
      var connection: Connection  = null
      var initialContext: InitialContext  = null

      try {
         // /Step 1. Create an initial context to perform the JNDI lookup.
         initialContext = getContext()

         // Step 2. perform a lookup on the topic
         val topic = initialContext.lookup("/topic/exampleTopic").asInstanceOf[Topic]

         // Step 3. perform a lookup on the Connection Factory
         val cf = initialContext.lookup("/ConnectionFactory").asInstanceOf[ConnectionFactory]

         // Step 4. Create a JMS Connection
         connection = cf.createConnection()

         // Step 5. Create a JMS Session
         val session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE)

         // Step 6. Create a Message Producer
         val producer = session.createProducer(topic)

         // Step 7. Create a JMS Message Consumer
         val messageConsumer1 = session.createConsumer(topic)

         // Step 8. Create a JMS Message Consumer
         val messageConsumer2 = session.createConsumer(topic)

         // Step 9. Create a Text Message
         val message = session.createTextMessage("This is a text message")

         println("Sent message: " + message.getText())

         // Step 10. Send the Message
         producer.send(message)

         // Step 11. Start the Connection
         connection.start()

         // Step 12. Receive the message
         val messageReceived = messageConsumer1.receive().asInstanceOf[TextMessage]

         println("Consumer 1 Received message: " + messageReceived.getText())

         // Step 13. Receive the message
         val messageReceived1 = messageConsumer2.receive().asInstanceOf[TextMessage]

         println("Consumer 2 Received message: " + messageReceived1.getText())

      } finally {
         // Step 14. Be sure to close our JMS resources!
         if (connection != null) {
            connection.close()
         }

         // Also the initialContext
         if (initialContext != null) {
            initialContext.close()
         }
      }
   }
}

object TopicExample extends App {
      new TopicExample().run()
}
// vim: set ts=4 sw=4 et:
