package com.jr.level.level18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
	private AmigoOutputStream component;

	public QuestionFileOutputStream(AmigoOutputStream component){
		this.component = component;
	}

	@Override
	public void flush() throws IOException {
		component.flush();
	}

	@Override
	public void write(int b) throws IOException {
		component.write(b);
	}

	@Override
	public void write(byte[] b) throws IOException {
		component.write(b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		component.write(b, off, len);
	}

	@Override
	public void close() throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Вы действительно хотите закрыть поток? Д/Н");
		if("Д".equals(rd.readLine())){
			component.close();
		}
	}
}

