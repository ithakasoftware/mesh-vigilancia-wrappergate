package com.ithaka.ufabc.openwebcam.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithaka.ufabc.openwebcam.db.entity.Camera;

public interface ICameraDAO extends JpaRepository<Camera, Integer> {

}
