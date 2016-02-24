package com.shenmajr.boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shenmajr.boot.domain.Attachment;
import com.shenmajr.boot.domain.Star;

public interface AttachmentRepo extends JpaRepository<Attachment, String> {
	
	public List<Attachment> findByStar(Star star);
	@Query("SELECT a FROM Attachment a WHERE a.star._id=:id AND a.recordStatus=0")
	public List<Attachment> findAllByStar(String id);
}
