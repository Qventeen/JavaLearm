package com.jr.level.level16.task1631;

import com.jr.level.level16.task1631.common.BmpReader;
import com.jr.level.level16.task1631.common.ImageReader;
import com.jr.level.level16.task1631.common.ImageTypes;
import com.jr.level.level16.task1631.common.JpgReader;
import com.jr.level.level16.task1631.common.PngReader;

public class ImageReaderFactory {
	public static ImageReader getImageReader(ImageTypes imageType){
		if(imageType == null)
			throw new IllegalArgumentException("Неизвестный тип картинки");


		ImageReader tmp = null;
		switch (imageType){
			case BMP: tmp = new BmpReader(); break;
			case JPG: tmp = new JpgReader(); break;
			case PNG: tmp = new PngReader(); break;
		}
		return tmp;
	}
}
