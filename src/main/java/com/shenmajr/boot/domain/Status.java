package com.shenmajr.boot.domain;

public enum Status {
	NORMAL(0,"正常"), //正常
	DELETE(1,"删除"), //删除
	RETREAD(2,"隐退"); //隐退
	
	private int flag;
	private String desc;
	
	/**
	 * Description: 枚举类型的构造方法
	 * @param flag 状态标记
	 * @param desc 状态描述
	 */
	private Status(int flag, String desc){
		this.flag = flag;
		this.desc = desc;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
