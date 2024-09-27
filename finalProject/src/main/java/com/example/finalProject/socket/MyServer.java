package com.example.finalProject.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;

        ServerSocket serverSocket = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
            serverSocket = new ServerSocket(8000);

            System.out.println("[Server실행] Client연결대기중...");
            socket = serverSocket.accept();			// 연결대기

            System.out.println("Client 연결됨.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),true);

            while(true) {
                String inputMessage = in.readLine();	// 수신데이터 한줄씩 읽기
                if ("quit".equalsIgnoreCase(inputMessage)) break;

                System.out.println("From Client: " + inputMessage);
                System.out.print("전송하기>>> ");

                String outputMessage = scanner.nextLine();
                out.println(outputMessage);
                out.flush();
                if ("quit".equalsIgnoreCase(outputMessage)) break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                scanner.close();		// Scanner 닫기
                socket.close();			// Socket 닫기
                serverSocket.close();		// ServerSocket 닫기
                System.out.println("연결종료");
            } catch (IOException e) {
                System.out.println("소켓통신에러");
            }
        }
    }
}
