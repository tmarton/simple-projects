package net.marton.trainingjournal.websocket;

import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by tmarton on 9/16/15.
 */
@Singleton
@ServerEndpoint("/activesockets")
public class ActiveSocketsEndpoint implements Serializable {

    private static final Set<Session> sessions =
            Collections.synchronizedSet(new HashSet<Session>());

    private Integer socketCounter = 0;

    @Inject
    @NewSocketevent
    Event<String> newSocketEvent;

    @Inject
    Logger logger;

    private Object lock;

    @OnOpen
    public void open(Session session) {
        this.sessions.add(session);
        socketCounter++;
        logger.info("Fire event with counter value "  + socketCounter);
        newSocketEvent.fire(socketCounter.toString());
    }

    @OnClose
    public void close(Session session, CloseReason c) {
        socketCounter--;
        logger.info("Fire event with counter value "  + socketCounter);
        newSocketEvent.fire(socketCounter.toString());
    }

    public void onEvent(@Observes @NewSocketevent String event) {
        logger.info("Send socket counter to value "  + event);
        Set<Session> closedSessions = new HashSet<Session>();
        for (Session session : sessions) {
            if (session.isOpen()) {
                try {
                    session.getBasicRemote().sendText(event);
                } catch (IOException ex) {
                    logger.info("IOException during send in websocket.");
                    closedSessions.add(session);
                }
            } else {
                closedSessions.add(session);
            }
        }
        sessions.removeAll(closedSessions);
    }
}
