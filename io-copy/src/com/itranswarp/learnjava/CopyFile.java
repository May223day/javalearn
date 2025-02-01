package com.itranswarp.learnjava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class CopyFile {

	public static void main(String[] args) throws IOException {
		String input = "D:\\gitcode\\javalearn\\io-copy\\test-file\\hello.docx";
		String output ="D:\\gitcode\\javalearn\\io-copy\\test-file\\hello2.docx"; //输出文件存放路径
		
		copy(input, output);
	}

	static void copy(String source, String target) throws IOException {
		// 友情提示：测试时请使用无关紧要的文件
		// 方法一：逐个字节读写，效率底下，不推荐！但这是我第一个想到的办法
		/*
		 try(InputStream input = new FileInputStream(source);
		    OutputStream output = new FileOutputStream(target)
			){
            int n;
			while ((n = input.read()) != -1) {
				output.write(n);
			}
		}
		 */
		
		//方法二：用缓冲流提高性能
		try(InputStream input = new FileInputStream(source);
		OutputStream output = new FileOutputStream(target)){
        byte[] data = new byte[8192]; //建立缓存区
		int bytesRead;
		while ((bytesRead = input.read(data)) != -1) { //读取到缓冲区
			output.write(data, 0, bytesRead);   
		}
	}
}
}