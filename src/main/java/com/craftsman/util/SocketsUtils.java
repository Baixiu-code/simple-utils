package com.craftsman.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public final class SocketsUtils {
	public static void main(String[] args){
		try {
			Socket s=new Socket("www.baidu.com",80);
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);
			BufferedReader reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out.println("GET / HTTP/1.1");
			out.println("Host:www.163.com/"); 
			out.println("contentType:text/html");
			String str=null;
			while((str=reader.readLine())!=null){
				System.out.println(str);
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
