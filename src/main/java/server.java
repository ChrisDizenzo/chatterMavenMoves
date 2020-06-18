import com.corundumstudio.socketio.*;
import com.corundumstudio.socketio.listener.DataListener;

public class server {
    public dataManager dm;


    public static void main(String[] args) {
        dataManager dm = new dataManager();
        System.out.println("Starting Server");
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(4004);
        final SocketIOServer server = new SocketIOServer(config);
        final chat puppy3 = new chat(0,"I like my brothers!","creebin","Today!");
        server.addEventListener("chat", message.class, new DataListener<message>() {
            @Override
            public void onData(final SocketIOClient socketIOClient, message m, AckRequest ackRequest) throws Exception {
                if (ackRequest.isAckRequested()){
                    ackRequest.sendAckData("client Message was delivered to server", "Alrighty");
                }
                puppy3.addChat(m);
                socketIOClient.sendEvent("ackevent2", new AckCallback<String>(String.class) {
                    @Override
                    public void onSuccess(String result) {
                        System.out.println("ack from client: " + socketIOClient.getSessionId() + " data: " + result);
                    }
                },puppy3);
            }
        });
        server.start();
    }

}
