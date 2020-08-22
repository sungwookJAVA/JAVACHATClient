package com.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

		public static void main(String[] args) {
			int port = 10000;
			String ServerIP = "127.0.0.1";
			
			try {
				Socket socket = new Socket(ServerIP, port);
				
				InputStream in = socket.getInputStream();
				DataInputStream dis = new DataInputStream(in);
				
				// 서버로부터 응답을 받음
				System.out.println("Message : " + dis.readUTF());
				
				// 핸들 닫고 종료
				dis.close();
				socket.close();
				System.out.println("연결 종료");
				
			} catch (UnknownHostException e) {
				System.out.println("존재하지 않은 IP 또는 Port");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
}
