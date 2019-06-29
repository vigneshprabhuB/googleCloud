package com.test.tryyy;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;

import javax.imageio.ImageIO;

public class ImageManuplation {

	public static void main(String a[]) throws Exception {
		//1
		//new ImageManuplation().resizeImageAndWrite("E:\\nh_logo.png", "E:\\sample1.png", 512,1024,"png");
		//3
		File inFile=new File("F:\\vitalmed.png");
		File inFile1=new File("F:\\vitalmed1.png");
		BufferedImage bufferedImage=ImageIO.read(inFile);
		BufferedImage out=new ImageManuplation().resizeImageAndReturn(bufferedImage, 36, 172, "png");
		ImageIO.write(out,"png",inFile1);
		System.out.println("dones...");

	}
	//with source file and destination path
	public boolean resizeImageAndWrite(String sourceFilePath,String destFilePath,int height,int width,String toConvertimageType) throws Exception{
		boolean result=false;
		try{
			BufferedImage inputImage = null;
			File ipimageFile = new File(sourceFilePath);
			File outimageFile = new File(destFilePath);
			inputImage = ImageIO.read(ipimageFile);
			BufferedImage outPut = new BufferedImage(width, height, inputImage.getType());
			// scales the input image to the output image
			Graphics2D g2d = outPut.createGraphics();
			g2d.drawImage(inputImage, 0, 0, width, height, null);
			g2d.dispose();
			ImageIO.write(outPut, toConvertimageType, outimageFile);
			result=true;
		}
		catch(FileNotFoundException fnfe){
		throw new Exception(fnfe.getCause());
		}
		catch(Exception e){
		throw e;
		}
		return result;
	}
	//with out source file path and with destination path
	public boolean resizeImageAndWrite(BufferedImage inBufferedImage,String destFilePath,int height,int width,String toConvertimageType) throws Exception{
		boolean result=false;
		try{
			BufferedImage inputImage = inBufferedImage;
			File outimageFile = new File(destFilePath);
			BufferedImage outPut = new BufferedImage(width, height, inputImage.getType());
			// scales the input image to the output image
			Graphics2D g2d = outPut.createGraphics();
			g2d.drawImage(inputImage, 0, 0, width, height, null);
			g2d.dispose();
			ImageIO.write(outPut, toConvertimageType, outimageFile);
			result=true;
		}catch(FileNotFoundException fnfe){
			throw new Exception(fnfe.getCause());
			}
			catch(Exception e){
			throw e;
			}
		return result;
	}
	//resize and return the image
	public BufferedImage resizeImageAndReturn(BufferedImage inputImageBuffer,int height,int width,String toConvertimageType) throws Exception{
		BufferedImage bufferedImage=null;
		try {
			BufferedImage inputImage = inputImageBuffer;
			bufferedImage = new BufferedImage(width, height,inputImage.getType());
			// scales the input image to the output image
			Graphics2D g2d = bufferedImage.createGraphics();
			g2d.drawImage(inputImage, 0, 0, width, height, null);
			g2d.dispose();
		}
		catch (Exception e) {
			throw e;
		}
		return bufferedImage;
	}

}
