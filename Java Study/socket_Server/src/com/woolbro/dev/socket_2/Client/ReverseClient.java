package com.woolbro.dev.socket_2.Client;


import java.net.*;
import java.io.*;


public class ReverseClient {
	
	 public static void main(String[] args) throws Exception{
	 
	        String hostname = "localhost"; //서버 주소
	        int port = 9099; //연결할 서버의 포트
	        
	        try (Socket socket = new Socket(hostname, port)) {
	 
	            OutputStream output = socket.getOutputStream();
	            PrintWriter writer = new PrintWriter(output, true);
	 
	            Console console = System.console();
	            String text;
	 
	            do {
	                text = console.readLine("Enter text: ");
	 
	                writer.println(text);
	 
	                InputStream input = socket.getInputStream();
	                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	 
	                String time = reader.readLine();
	 
	                System.out.println(time);
	 
	            } while (!text.equals("bye"));
	 
	            socket.close();
	 
	        } catch (UnknownHostException ex) {
	 
	            System.out.println("Server not found: " + ex.getMessage());
	 
	        } catch (IOException ex) {
	 
	            System.out.println("I/O error: " + ex.getMessage());
	        }
	    }

}
