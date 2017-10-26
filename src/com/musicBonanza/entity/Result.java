package com.musicBonanza.entity;

import java.util.*;
import javax.persistence.Entity;

public class Result implements java.io.Serializable{
private List<?> resultList;
public List<?> getResultList() {
	return resultList;
}
public void setResultList(List<?> resultList) {
	this.resultList = resultList;
}
public List<Integer> getPrimaryIdList() {
	return primaryIdList;
}
public void setPrimaryIdList(List<Integer> primaryIdList) {
	this.primaryIdList = primaryIdList;
}
public int getResultCount() {
	return resultCount;
}
public void setResultCount(int resultCount) {
	this.resultCount = resultCount;
}
public int getStatusCode() {
	return statusCode;
}
public void setStatusCode(int statusCode) {
	this.statusCode = statusCode;
}
public String getStatusMessage() {
	return statusMessage;
}
public void setStatusMessage(String statusMessage) {
	this.statusMessage = statusMessage;
}
private List<Integer> primaryIdList;
private int resultCount;
private int statusCode;
private String statusMessage;

}