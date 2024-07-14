package com.ithaka.ufabc.openwebcam.provider;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ithaka.ufabc.openwebcam.db.entity.Camera;
import com.ithaka.ufabc.openwebcam.db.repository.ICameraDAO;
import com.ithaka.ufabc.openwebcam.db.repository.IUserDAO;
import com.ithaka.ufabc.openwebcam.dto.CameraDTO;
import com.ithaka.ufabc.openwebcam.dto.UserDTO;

@Component
public class CameraProvider {
	
	@Autowired
	ICameraDAO cameraDAO;
	
	@Autowired
	IUserDAO userDAO;
	
	public List<CameraDTO> listAllCameras() {
		
		var cameras = cameraDAO.findAll();
		
		var camDtos = cameras.stream().map((camera)->{
			var cameraDTO = convertCameraToDTO(camera);
			
			return cameraDTO;
		}).collect(Collectors.toList());
		
		return camDtos;
	}

	private CameraDTO convertCameraToDTO(Camera camera) {
		var owner = userDAO.findByLogin(camera.getOwner());
		
		var ownerDTO = UserDTO.builder()
					.id(owner.getId())
					.name(owner.getName())
					.login(owner.getLogin())
					.build();
		
		var cameraDTO = CameraDTO.builder()
			.id(camera.getId())
			.description(camera.getDescription())
			.latitude(camera.getLatitude())
			.longitude(camera.getLongitude())
			.owner(ownerDTO)
			.uri(camera.getUri())
			.build();
		return cameraDTO;
	}

	public CameraDTO findById(Integer idcam) {
		var cameraOpt = cameraDAO.findById(idcam);
		return (cameraOpt.isEmpty()) ? null : convertCameraToDTO(cameraOpt.get());
	}

}
