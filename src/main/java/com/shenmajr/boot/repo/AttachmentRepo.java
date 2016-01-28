package com.shenmajr.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shenmajr.boot.domain.Attachment;

public interface AttachmentRepo extends JpaRepository<Attachment, String> {
	
	@Query("SELECT a FROM Attachment a WHERE a.star._id=:id AND a.recordStatus=0")
	public Attachment findEffectByStar(String id);
}
