package lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.String.format;

public class NetClient {
//    public static Scanner sc = new Scanner(System.in);
//    public static boolean isWorkClient = true;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket("localhost", 87);
        boolean isWorkClient = true;
        System.out.println(">>Client start");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Thread inputNetMSG = new Thread(() -> {
            while (true) {
                String inputData = sc.nextLine();
                try {
//                    String inputData = in.readUTF();
//                    System.out.println(format("S->:%s", inputData));
                    System.out.println(format("C:%s", inputData));
                    out.writeUTF(inputData);
                    out.flush();

                    if(inputData.contains("exit")) {
                        System.out.println("--- exit ---");
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        inputNetMSG.start();

        while (isWorkClient) {
//            String textMSG = sc.nextLine();
//            out.writeUTF(textMSG);
//            out.flush();

            String textMSG = in.readUTF();
//            System.out.println("C: " + textMSG);
            System.out.println("S->: " + textMSG);

            if (textMSG.contains("exit")) {
                isWorkClient = false;
            }

//            System.out.println("C: " + textMSG);
        }
        socket.close();

        System.out.println(">>Client finish");
        System.out.println(inputNetMSG.isAlive());
    }
}

