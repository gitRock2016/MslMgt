package com.iwatakhr.mslmgt.presentation.controller.form;

import java.util.List;

public class TrgRecordListRegistEditForm {
	private String eventsName;
	private String trainingStartTime;
	
	private List<TrgRecordListRegistEditDetailForm> detailForms;

	public String getEventsName() {
		return eventsName;
	}

	public void setEventsName(String eventsName) {
		this.eventsName = eventsName;
	}

	public String getTrainingStartTime() {
		return trainingStartTime;
	}

	public void setTrainingStartTime(String trainingStartTime) {
		this.trainingStartTime = trainingStartTime;
	}

	public List<TrgRecordListRegistEditDetailForm> getDetailForms() {
		return detailForms;
	}

	public void setDetailForms(List<TrgRecordListRegistEditDetailForm> detailForms) {
		this.detailForms = detailForms;
	}
}
