import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadServer {

    public ThreadServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server listening on port: 3000");

            int i = 0;
            while(true){
                Socket connectionSocket = serverSocket.accept();
                System.out.println("Client" + i + " connected");
                Thread thread = new Thread(new SocketHandler(connectionSocket),"Socket Thread");
                thread.start();
                i++;
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

}

class SocketHandler implements Runnable{

    private Socket socket;
    public SocketHandler(Socket connectionSocket){
        this.socket = connectionSocket;
    }

    @Override
    public void run() {
        try {
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            String body = "";
            String response = "";
            body = inputStream.readUTF();
            while(!body.equalsIgnoreCase("over")){
                response = response.concat(body);
                outputStream.writeUTF("data received. content: { " + body + " }");
                System.out.println("new data: { " + body + " }");
                body = inputStream.readUTF();
            }

            outputStream.writeUTF("server response: { " + response + "} ");
            outputStream.flush();
            outputStream.close();
            inputStream.close();

            socket.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
