package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import been.User;

public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Main m=new Main();
//		m.fileIO();
//		m.objectIO();
		m.stringFileIO();
	}
	
	public  void fileIO() throws IOException
	{
		FileInputStream input=new FileInputStream("C:\\Users\\гъ\\Desktop\\input.txt");
		FileOutputStream output=new FileOutputStream("C:\\Users\\гъ\\Desktop\\output.txt",true);
		input.transferTo(output);
		input.close();
		output.close();
	}
	
	public void objectIO() throws IOException, ClassNotFoundException
	{
		User user=new User();
		user.setName("objectOutputTest");
		FileOutputStream output=new FileOutputStream("C:\\Users\\гъ\\Desktop\\objectOutput.txt",true);
		ObjectOutputStream objectOutput=new ObjectOutputStream(output);
		objectOutput.writeObject(user);
		FileInputStream input=new FileInputStream("C:\\Users\\гъ\\Desktop\\objectOutput.txt");
		ObjectInputStream objectInput=new ObjectInputStream(input);
		User u2=(User) objectInput.readObject();
		System.out.println(u2.getName());
		objectOutput.close();
		objectInput.close();
	}
	public void stringFileIO() throws IOException
	{
		FileReader fileReader=new FileReader("C:\\Users\\гъ\\Desktop\\input.txt");
		char[] cbuf=new char[5];
		while(fileReader.read(cbuf)!=-1)
		{
			for(char c:cbuf)
				System.out.print(c);
		}
		fileReader.close();
		
		fileReader=new FileReader("C:\\Users\\гъ\\Desktop\\input.txt");
		FileWriter fileWriter=new FileWriter("C:\\Users\\гъ\\Desktop\\output.txt",true);
		fileReader.transferTo(fileWriter);
		fileWriter.close();
		fileReader.close();
	}
	
}
