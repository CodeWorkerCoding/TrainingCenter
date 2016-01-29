package com.shenmajr.boot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.shenmajr.boot.utils.UUIDUtil;

@Entity
@Table(name="star")
public class Star implements Serializable  {
	
	/**
	 *Created by fujianjian 2016年1月25日
	 */
	private static final long serialVersionUID = -1838955755445408929L;
	
	@Id
	private String _id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 别名
	 */
	private String nickname;
	/**
	 * 三围
	 */
	private String mensurations;
	/**
	 * 作品链接
	 */
	@OneToMany(targetEntity=Ed2k.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY
			, mappedBy="star")
	//updatable=false 很关键，在级联删除的时候就会报错(反转的问题)
	private Set<Ed2k> ed2ks;
	/**
	 * 图片
	 */
	@OneToMany(targetEntity=Attachment.class, cascade=CascadeType.ALL, fetch=FetchType.LAZY,
			mappedBy="star")
	private Set<Attachment> images;
	
	private Date createTime;
	private Date updateTime;
	
	@Enumerated(EnumType.ORDINAL)
	private Status  recordStatus;
	
	public Star() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname == null ? null : nickname.trim();
	}

	public String getMensurations() {
		return mensurations;
	}

	public void setMensurations(String mensurations) {
		this.mensurations = mensurations;
	}
	
	public Set<Ed2k> getEd2ks() {
		return ed2ks;
	}

	public void setEd2ks(Set<Ed2k> ed2ks) {
		this.ed2ks = ed2ks;
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
