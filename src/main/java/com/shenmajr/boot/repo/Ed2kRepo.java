package com.shenmajr.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shenmajr.boot.domain.Ed2k;

public interface Ed2kRepo extends JpaRepository<Ed2k, String> {

}
