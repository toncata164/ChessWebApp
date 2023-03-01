package edu.school.chess;

import edu.school.chess.logic.Game;
import edu.school.chess.logic.IGame;
import org.json.JSONArray;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chess")
public class ChessEndpoint {
    private static IGame game = new Game();
    @OnOpen
    public void onOpen(Session session, EndpointConfig config){
        JSONArray jsonFigures = new JSONArray(game.getTable());
        if(session.isOpen()) {
            try {
                session.getBasicRemote().sendText(jsonFigures.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @OnMessage
    public void onMessage(Session session, String message){
        if(message.startsWith("move")){
            String[] splitted = message.split(" ");
            if(splitted.length != 3){
                throw new IllegalArgumentException("Wrong number of arguments!");
            }
            int row = Integer.parseInt(splitted[1]);
            int column = Integer.parseInt(splitted[2]);
            game.move(row, column);
        }
        else if(message.startsWith("select")){//select 7 0
            String[] splitted = message.split(" ");
            if(splitted.length != 3){
                throw new IllegalArgumentException("Wrong number of arguments!");
            }
            int row = Integer.parseInt(splitted[1]);
            int column = Integer.parseInt(splitted[2]);
            game.select(row, column);
        }
        JSONArray jsonFigures = new JSONArray(game.getTable());
        for(Session s : session.getOpenSessions()){
            if(s.isOpen()){
                try {
                    s.getBasicRemote().sendText(jsonFigures.toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @OnError
    public void onError(Session session, Throwable throwable){

    }

    @OnClose
    public void onClose(Session session, CloseReason reason){

    }
}
