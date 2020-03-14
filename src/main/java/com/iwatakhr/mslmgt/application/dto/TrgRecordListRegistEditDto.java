package com.iwatakhr.mslmgt.application.dto;

import java.time.LocalDateTime;
import java.util.List;

public class TrgRecordListRegistEditDto {
	private LocalDateTime trainingStartTime;
	private String eventsNameId;
	private List<TrgRecordDetailDto> detailList;

	public TrgRecordListRegistEditDto() {
		super();
	}

	public TrgRecordListRegistEditDto(LocalDateTime trainingStartTime, String eventsName,
			List<TrgRecordDetailDto> detailList) {
		this.trainingStartTime = trainingStartTime;
		this.eventsNameId = eventsName;
		this.detailList = detailList;
	}

	public LocalDateTime getTrainingStartTime() {
		return trainingStartTime;
	}

	public void setTrainingStartTime(LocalDateTime trainingStartTime) {
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
