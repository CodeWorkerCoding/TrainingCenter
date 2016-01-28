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

/**
 * ClassName: Attachment
 * Description: 附件表，主要用于存储明星的图片
 * Author: fujianjian
 * Date: 2016年1月27日
 */
@Entity
@Table(name="attachment")
public class Attachment implements Serializable {

	/**
	 *Created by fujianjian 2016年1月27日
	 */
	private static final long serialVersionUID = 8947647562253557792L;
	@Id
	private String _id;
	private String name;
	/**
	 * 图片存放路径
	 */
	private String url;
	/**
	 * 文件类型 就是图片的格式 jpg png 等
	 */
	@Column(length=5)
	private String type;
	/**
	 * 图片归属与那个明星
	 */
	@ManyToOne(targetEntity=Star.class, fetch=FetchType.LAZY)
	@JoinColumn(name="star_id",updatable=false)
	private Star star;
	/**
	 * 图片状态
	 */
	private Status recordStatus;
	/**
	 * 图片上传时间
	 */
	private Date createTime;
	/**
	 * 图片更新时间
	 */
	private Date updateTime;
	
	public Attachment() {
	}
	
	@PrePersist
	public void createOn(){
		this._id = UUIDUtil.genUUID();
		this.createTime = new Date();
		this.updateTime = new Date();
	}
	@PreUpdate
	public void modify(){
		this.updateTime=new Date();
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
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Star getStar() {
		return star;
	}
	public void setStar(Star star) {
		this.star = star;
	}
	public Status getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(Status recordStatus) {
		this.recordStatus = recordStatus;
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
}
