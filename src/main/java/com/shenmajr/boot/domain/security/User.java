package com.shenmajr.boot.domain.security;

import java.util.Collection;
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
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.utils.UUIDUtil;

@Entity
@Table(name="sec_user")
public class User implements UserDetails {

	/**
	 *Created by fujianjian 2016年2月18日
	 */
	private static final long serialVersionUID = 7527798775726424023L;

	@Id
	private String _id;
	@Column(length=50,nullable=false)
	private String username;
	@Column(length=50, nullable=false)
	private String password;
	@Enumerated(EnumType.ORDINAL)
	private Status status;
	private String descn;
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinTable(name="sec_user_role",
		joinColumns={@JoinColumn(name="userid",referencedColumnName="_id")},
		inverseJoinColumns={@JoinColumn(name="roleid",referencedColumnName="_id")})
	private Set<Role> roles;
	
	//实现接口的属性/
	private boolean expired = false;
	private boolean locked = false;
	private boolean credentialsExpired = false;
	private boolean enabled = false;
	@Transient
	private Collection<? extends GrantedAuthority> authorities; 
	///
	
	private Date createTime;
	private Date	 updateTime;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	@Override
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public User() {
	}
	
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

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return !expired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return !credentialsExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}

	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this._id == null) ? 0 : this._id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (this._id == null) {
			if (other._id != null) {
				return false;
			}
		}else if (! this._id.equals(other._id)) {
			return false;
		}
		return true;
	}
}
