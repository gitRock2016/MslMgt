package com.iwatakhr.mslmgt.application.dto;

import java.util.List;

public class TrgRecordListRegistEditDto {
	private String trainingStartTime;
	private String eventsName;
	private List<TrgRecordDetailDto> detailList;
	
	
	public TrgRecordListRegistEditDto() {
		super();
	}
	public TrgRecordListRegistEditDto(
			  String trainingStartTime
			, String eventsName
			, List<TrgRecordDetailDto> detailList) {
		this.trainingStartTime = trainingStartTime;
		this.eventsName = eventsName;
		this.detailList = detailList;
	}
	
	
	public String getTrainingStartTime() {
		return trainingStartTime;
	}
	public void setTrainingStartTime(String trainingStartTime) {
		this.trainingStartTime = trainingStartTime;
	}
	public String getEventsName() {
		return eventsName;
	}
	public void setEventsName(String eventsName) {
		this.eventsName = eventsName;
	}
	public List<TrgRecordDetailDto> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TrgRecordDetailDto> detailList) {
		this.detailList = detailList;
	}
	
	
}
