import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public Client1(){
        try{
            Socket socket = new Socket("localhost",3000);

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);

            String input = scanner.nextLine();
            String body = "";
            String response = "";
            while(!input.equalsIgnoreCase("over")){
                outputStream.writeUTF(input);
                body = inputStream.readUTF();
                System.out.println(body);
                response = response.concat(body + "\n");

                input = scanner.nextLine();
            }

            outputStream.writeUTF(input);

            System.out.print("data:\n" + response);

            outputStream.flush();
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
