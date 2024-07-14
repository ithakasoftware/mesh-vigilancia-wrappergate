package com.ithaka.ufabc.openwebcam.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="cameras")
public class Camera {

	@Id
	private int id;
	
	@Column
	private String description;
	
	@Column
	private String owner; 
	
	@Column
	private float latitude;
	
	@Column
	private float longitude;
	
	@Column
	private String uri;
}
