package com.ithaka.ufabc.openwebcam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ithaka.ufabc.openwebcam.dto.CameraDTO;
import com.ithaka.ufabc.openwebcam.provider.CameraProvider;

@Service
public class WebCamServices {

	
	@Autowired
	CameraProvider cameraProvider;
	
	public List<CameraDTO> listAllCameras() {
		
		return cameraProvider.listAllCameras();
		
	}
	
	public CameraDTO findCamera(Integer idcam) {
		return cameraProvider.findById(idcam);
	}

}
