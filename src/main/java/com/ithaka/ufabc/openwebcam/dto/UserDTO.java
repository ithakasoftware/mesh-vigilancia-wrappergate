package com.ithaka.ufabc.openwebcam.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

	private int id;
	
	private String name;
	
	private String login;
	
	private List<CameraDTO> cameras;
}
