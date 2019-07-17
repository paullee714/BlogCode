package com.woolbro.dev.socket.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("#######Need More Arguments #########");
            return;
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);
        for (int i = 0; i < 10; i++) {
            try (Socket socket = new Socket(hostname, port)) {
                OutputStream out = socket.getOutputStream();
                String realStr = "This is woolbro dev Test";
                out.write(realStr.getBytes());
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String time = reader.readLine();

                System.out.println(time);

            } catch (UnknownHostException ex) {

                System.out.println("Server not found: " + ex.getMessage());

            } catch (IOException ex) {

                System.out.println("I/O error: " + ex.getMessage());
            }
        }

    }

}
