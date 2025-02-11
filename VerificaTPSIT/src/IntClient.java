import java.io.*;
import java.net.*;
import java.util.*;

public class IntClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("localhost", 9998)){
            System.out.println("Connetion enstablished");
        System.out.println("Define how many numbers you want to generate: ");
        Scanner lenght = new Scanner(System.in);
        String len = lenght.nextLine();
        int L=Integer.parseInt(len);
        s.getOutputStream().write(L);
       ArrayList<Integer> Number = new ArrayList<Integer>();
        for(int i=0; i<=L; i++){int numero = (int) (Math.random()*L); Number.add(numero);}
        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject(Number);

            System.out.println("Client has send this vector of numbers");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}