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
				
				// �����κ��� ������ ����
				System.out.println("Message : " + dis.readUTF());
				
				// �ڵ� �ݰ� ����
				dis.close();
				socket.close();
				System.out.println("���� ����");
				
			} catch (UnknownHostException e) {
				System.out.println("�������� ���� IP �Ǵ� Port");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
}
