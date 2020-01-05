package com.iwatakhr.mslmgt.application.dto;

import java.util.List;

public class TrgRecordListDto {
	private String trainingStartTime;
	private String eventsNameId;
	private List<TrgRecordDetailDto> detailList;
	
	public String getTrainingStartTime() {
		return trainingStartTime;
	}
	public void setTrainingStartTime(String trainingStartTime) {
		this.trainingStartTime = trainingStartTime;
	}
	public String getEventsNameId() {
		return eventsNameId;
	}
	public void setEventsNameId(String eventsNameId) {
		this.eventsNameId = eventsNameId;
	}
	public List<TrgRecordDetailDto> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TrgRecordDetailDto> detailList) {
		this.detailList = detailList;
	}


	
	
}
