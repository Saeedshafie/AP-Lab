import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(3000);
            System.out.println("Server is running at port: 3000");
            Socket connectionSocket = serverSocket.accept();

            String body = "";
            String response = "";
            DataOutputStream outputStream = new DataOutputStream(connectionSocket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(connectionSocket.getInputStream());
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
            connectionSocket.close();
            serverSocket.close();
        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
