package com.ithaka.ufabc.openwebcam.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CameraDTO {
	
	private int id;
	

	private String description;
	

	private UserDTO owner; 
	

	private float latitude;
	

	private float longitude;
	
	private String uri;

}
