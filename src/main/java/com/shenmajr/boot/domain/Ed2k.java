package com.shenmajr.boot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.shenmajr.boot.utils.UUIDUtil;

@Entity
@Table(name="ed2k")
public class Ed2k implements Serializable {
	
	/**
	 *Created by fujianjian 2016年1月25日
	 */
	private static final long serialVersionUID = 437949083750495662L;
	@Id
	private String _id;
	@ManyToOne(targetEntity=Star.class, fetch=FetchType.LAZY)
	@JoinColumn(name="star_id",updatable=false)
	private Star star; //明星
	@Column(length=32, nullable=false)
	private String designation; //作品名称
	@Column(nullable=false)
	private String ed2k; //作品地址
	
	private Date createTime;
	private Date updateTime;
	private Status  recordStatus;
	
	public Ed2k() {
	}
	
	@PrePersist
	public void createOn() {
		this._id = UUIDUtil.genUUID();
		this.createTime = new Date();
		this.updateTime = new Date();
	}
	
	@PreUpdate
	public void modify(){
		this.updateTime = new Date();
	}
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Star getStar() {
		return star;
	}
	
	public void setStar(Star star) {
		this.star = star;
	}
	
	public String getEd2k() {
		return ed2k;
	}
	
	public void setEd2k(String ed2k) {
		this.ed2k = ed2k;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Status getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(Status recordStatus) {
		this.recordStatus = recordStatus;
	}
}
