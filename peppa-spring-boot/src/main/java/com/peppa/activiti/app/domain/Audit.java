package com.peppa.activiti.app.domain;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Audit{

	private String auditResult;

	private String auditReason;

	public void setAuditResult(String auditResult){
		this.auditResult = auditResult;
	}

	public String getAuditResult(){
		return auditResult;
	}

	public void setAuditReason(String auditReason){
		this.auditReason = auditReason;
	}

	public String getAuditReason(){
		return auditReason;
	}

	@Override
 	public String toString(){
		return 
			"Audit{" + 
			"audit_result = '" + auditResult + '\'' + 
			",audit_reason = '" + auditReason + '\'' + 
			"}";
		}
}