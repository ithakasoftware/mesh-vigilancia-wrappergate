package com.ithaka.ufabc.openwebcam.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.ithaka.ufabc.openwebcam.dto.CameraDTO;
import com.ithaka.ufabc.openwebcam.service.WebCamServices;

@RestController
public class WrapperGate {
	
	@Autowired
	WebCamServices webCamServices;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/findframes/{idcam}") 
	public List<String> findIdCamAndCaptureFrames(@PathVariable Integer idcam){
		
		var camera = webCamServices.findCamera(idcam);
		
		RestClient restClient = RestClient.create();
		
		return restClient.get()
			.uri(camera.getUri())
			.retrieve()
			.body(List.class);		
		
	}
	
	@GetMapping("/listcams")
	public List<CameraDTO> listIdCams() {
		
		return webCamServices.listAllCameras();
	}
	
	@GetMapping("/ownercams")
	public List<Integer> listOwnerCams() {
		
		return new ArrayList<Integer>();
	}

}
