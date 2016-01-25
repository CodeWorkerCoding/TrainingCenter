package com.shenmajr.boot.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * ClassName: BaseDomain
 * Description: 基础实体类
 * Author: fujianjian
 * Date: 2016年1月25日
 */
public class BaseDomain implements Serializable {
	
	/**
	 *Created by fujianjian 2016年1月25日
	 */
	private static final long serialVersionUID = -5266281102233646519L;
	
	protected Date createtime;
	protected Date updatetime;
	protected Status recordstatus;
	
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Status getRecordstatus() {
		return recordstatus;
	}
	public void setRecordstatus(Status recordstatus) {
		this.recordstatus = recordstatus;
	}
}
