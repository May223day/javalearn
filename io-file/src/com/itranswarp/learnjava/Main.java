package com.itranswarp.learnjava;

import java.io.File;
import java.io.IOException;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 *   
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws IOException {
		File currentDir = new File("D:\\学习\\swufe\\sunny");
		System.out.println(currentDir.getName()+"/");
		listDir(currentDir.getCanonicalFile()," ",true);
	}

	static void listDir(File dir, String indent, boolean isLast) {
        File[] files = dir.listFiles();
        if (files == null) return;

        int count = files.length;
        for (int i = 0; i < count; i++) {
            File f = files[i];
            boolean last = (i == count - 1);
            
            // 打印当前条目前缀
            System.out.print(indent);
            if (last) {
                System.out.print("└── ");
            } else {
                System.out.print("├── ");
            }

            if (f.isDirectory()) {
                // 打印目录名称并递归
                System.out.println(f.getName() + "/");
                listDir(f, 
                    indent + (last ? "    " : "│   "), // 更新缩进
                    last);
            } else {
                // 打印文件名称
                System.out.println(f.getName());
            }
        }
    }
}

