
import java.io.*;
import java.net.*;
import java.util.*;


public class IntServer {
    public static void main(String[] args) throws ClassNotFoundException {
        try (ServerSocket ss = new ServerSocket(9998)) {
            System.out.println("Server avviato è in attesa di connessioni");
            while (true) {
                

                try (Socket s = ss.accept()) {

                    System.out.println("Connessione accettata da: " + s.getInetAddress());
                    
                    int len = s.getInputStream().read();
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                    ArrayList<Integer> RecivedNumbers = (ArrayList<Integer>) in.readObject();
                    Collections.sort(RecivedNumbers);
                    System.out.print(RecivedNumbers);
                     
                    
                } catch (IOException e) {
                    System.err.println("Errore nella comunicazione con il client: " + e.getMessage()); 
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}