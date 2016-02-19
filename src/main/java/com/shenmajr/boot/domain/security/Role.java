package com.shenmajr.boot.domain.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.utils.UUIDUtil;

@Entity
@Table(name="sec_role")
public class Role implements Serializable {

	/**
	 *Created by fujianjian 2016年2月18日
	 */
	private static final long serialVersionUID = -5045788230838771234L;

	@Id
	private String _id;
	@Column(length=50,nullable=false)
	private String name;
	private String descn;
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(name="sec_user_role",
			joinColumns={@JoinColumn(name="roleid",referencedColumnName="_id")},
			inverseJoinColumns={@JoinColumn(name="userid",referencedColumnName="_id")})
	private Set<User> users;
	
	private Date createTime;
	private Date updateTime;
	
	@PrePersist
	public void onCreate(){
		this._id = UUIDUtil.genUUID();
		this.createTime = new Date();
		this.updateTime = new Date();
	}
	@PreUpdate
	public void onUpdate(){
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

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
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
