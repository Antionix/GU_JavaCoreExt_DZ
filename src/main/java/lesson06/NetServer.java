package lesson06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.String.format;

public class NetServer {
    //    public static TreeMap<Long, String> messageList = new TreeMap<>();
    public static boolean isWork = true;
//    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        boolean isWork = true;
//        String clientName = "Client";
        Scanner sc = new Scanner(System.in);
        System.out.println(">>> Server start");

        ServerSocket server = new ServerSocket(87);
        System.out.println(server.getInetAddress());

        Socket con = server.accept();
        System.out.println("Connect start" + con.getInetAddress());

        DataInputStream in = new DataInputStream(con.getInputStream());
        DataOutputStream out = new DataOutputStream(con.getOutputStream());

        Thread inputConsoleMSG = new Thread(() -> {
            while (isWork) {
                String inputData = sc.nextLine();
                System.out.println(isWork);
                System.out.println(format("S:%s", inputData));
                try {
                    if (inputData.contains("bye")) {
                        out.writeUTF("exit");
                        break;
                    } else {
                        out.writeUTF(inputData);
                    }
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        inputConsoleMSG.start();

        while (isWork) {
            String textMSG = in.readUTF();
            System.out.println("<-C: " + textMSG);

            System.out.println("S>: " + textMSG);
            out.writeUTF(textMSG);
            out.flush();

            if (textMSG.contains("exit")) {
                isWork = false;
//                out.writeUTF("Bye!!!");
//                out.flush();
            }
        }
        con.close();
        server.close();

        System.out.println(">>> Server finish");
        System.out.println(inputConsoleMSG.isAlive());
    }
}
