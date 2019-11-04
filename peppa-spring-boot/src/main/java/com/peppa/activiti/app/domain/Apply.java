package com.peppa.activiti.app.domain;

import java.io.Serializable;

public class Apply implements Serializable {
	private String reason;
	private int cavNum;
	private String startDay;
	private String cancelApply;

	public void setReason(String reason){
		this.reason = reason;
	}

	public String getReason(){
		return reason;
	}

	public void setCavNum(int cavNum){
		this.cavNum = cavNum;
	}

	public int getCavNum(){
		return cavNum;
	}

	public void setStartDay(String startDay){
		this.startDay = startDay;
	}

	public String getStartDay(){
		return startDay;
	}

	public void setCancelApply(String cancelApply){
		this.cancelApply = cancelApply;
	}

	public String getCancelApply(){
		return cancelApply;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"reason = '" + reason + '\'' + 
			",cav_num = '" + cavNum + '\'' + 
			",start_day = '" + startDay + '\'' + 
			",cancel_apply = '" + cancelApply + '\'' + 
			"}";
		}
}
