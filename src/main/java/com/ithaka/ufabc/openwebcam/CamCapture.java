package com.ithaka.ufabc.openwebcam;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.global.opencv_imgcodecs;
import org.bytedeco.opencv.opencv_core.IplImage;

public class CamCapture {
	
	public List<String> captureFrame(Integer idCam, Integer seconds) {
		
		CanvasFrame canvas = new CanvasFrame("Web Cam");
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		var imagesEncoded64 = new ArrayList<String>();

		try {
			OpenCVFrameGrabber grabber = new OpenCVFrameGrabber(idCam);
			OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
			grabber.start();

			for (int i = 0; i<seconds;i++) {
				Frame frame = grabber.grabFrame();

				IplImage img = converter.convert(frame);
				
				opencv_imgcodecs.cvSaveImage("imageCam.jpg", img);
				
				canvas.showImage(frame);
				
				File fileImage = new File("./imageCam.jpg");
				
				BufferedImage originalImage=ImageIO.read(fileImage);
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				ImageIO.write(originalImage, "jpg", baos );
				 
				byte[] imageInByte = baos.toByteArray(); 
				
				imagesEncoded64.add(Base64.getEncoder().encodeToString(imageInByte));

				
				Thread.sleep(500);

			}
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//canvas.dispatchEvent(new WindowEvent(canvas, WindowEvent.WINDOW_CLOSING));
		
		return imagesEncoded64;
	
	}

}
