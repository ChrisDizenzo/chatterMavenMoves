import io.socket.emitter.Emitter;
import io.socket.engineio.server.EngineIoServer;
import io.socket.socketio.server.SocketIoNamespace;
import io.socket.socketio.server.SocketIoServer;
import io.socket.socketio.server.SocketIoSocket;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class server extends HttpServlet {
    public dataManager dm;

    private final EngineIoServer engine = new EngineIoServer();
    private final SocketIoServer socketIoServer = new SocketIoServer(engine);
    SocketIoNamespace namespace = socketIoServer.namespace("/");


    public void runServer(){
        SocketIoNamespace namespace = socketIoServer.namespace("/");
        namespace.on("connection", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                SocketIoSocket socket = (SocketIoSocket) args[0];
                socket.emit("I'm here and listening");
            }
        });
    }
    public static void main(String[] args) {
        dataManager dm = new dataManager();
        System.out.println("Starting Server");
        try{
            server pup = new server();
            pup.runServer();
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        engine.handleRequest(request, response);
    }
}
