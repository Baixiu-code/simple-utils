package com.craftsman.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 
* @ClassName: IOUtils
* @Description: IO�Ĺ����࣬����NIO�Լ�IO���÷���
* @author �·���
* @date 2015��12��9�� ����11:07:18
*
 */
public class IOUtils {
	
	public static void testNIO() throws IOException{
		FileInputStream fin=new FileInputStream("C:\\Users\\Administrator\\Desktop\\��ƽӿڵ�ַ-2015��11��2��.txt");
		FileChannel fc=fin.getChannel();
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		fc.read(buffer);		
	}
	
	public static void main(String[] args) throws IOException{
		testNIO();
	}
}
