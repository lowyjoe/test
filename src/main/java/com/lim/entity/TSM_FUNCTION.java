package com.lim.entity;

public class TSM_FUNCTION {
 
	private String fldid;
	private String fldsfuncname;
	private int fldorder;
	private String fldparentid;
	public String getFldid() {
		return fldid;
	}
	public void setFldid(String fldid) {
		this.fldid = fldid;
	}
	public String getFldsfuncname() {
		return fldsfuncname;
	}
	public void setFldsfuncname(String fldsfuncname) {
		this.fldsfuncname = fldsfuncname;
	}
	 
	public String getFldparentid() {
		return fldparentid;
	}
	public void setFldparentid(String fldparentid) {
		this.fldparentid = fldparentid;
	}
	public int getFldorder() {
		return fldorder;
	}
	public void setFldorder(int fldorder) {
		this.fldorder = fldorder;
	}
	@Override
	public String toString() {
		return "TSM_FUNCTION [fldid=" + fldid + ", fldsfuncname="
				+ fldsfuncname + ", fldorder=" + fldorder + ", fldparentid="
				+ fldparentid + "]";
	}

}
