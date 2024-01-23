package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8988;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("New connection accepted");

                out.println("Добро пожаловать! Пожалуйста введите логин.");

                final String name = in.readLine();
                out.println(String.format("Введено: %s", name));
                out.println(String.format("Вы входите как: %s", name));
                out.println("Введите пароль");

                final int password = Integer.parseInt(in.readLine());
                out.println(String.format("Введено: %d", password));
                out.println(String.format("Вы вошли как: %s", name));
                out.println("Спасибо что пользуетесь нашим ресурсом.");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}