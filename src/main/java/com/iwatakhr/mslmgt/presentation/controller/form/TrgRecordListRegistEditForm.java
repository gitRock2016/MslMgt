package com.iwatakhr.mslmgt.presentation.controller.form;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class TrgRecordListRegistEditForm {
	
	/*
	 * TODO 単項目チェックをいれたい
	 */	
	private String eventsNameId;
//	private String trainingStartTime;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime trainingStartTime;
	
	private List<TrgRecordListRegistEditDetailForm> detailForms;

	public TrgRecordListRegistEditForm() {
		super();
		initialForm();
//		mock1();
	}
	
	private void initialForm() {
		this.eventsNameId = "";
		this.trainingStartTime = LocalDateTime.now();
		this.detailForms = initDetailFormList();
	}
	private List<TrgRecordListRegistEditDetailForm> initDetailFormList() {
		List<TrgRecordListRegistEditDetailForm> list = new ArrayList<TrgRecordListRegistEditDetailForm>();
		list.add(new TrgRecordListRegistEditDetailForm());
		list.add(new TrgRecordListRegistEditDetailForm());
		list.add(new TrgRecordListRegistEditDetailForm());
		return list;
	}
	
	
	// TODO mock
	private void mock1() {
		this.eventsNameId = "";
		this.trainingStartTime = LocalDateTime.now();
		this.detailForms = mock_initDetailFormList();
	}
	private List<TrgRecordListRegistEditDetailForm> mock_initDetailFormList() {
		List<TrgRecordListRegistEditDetailForm> list = new ArrayList<TrgRecordListRegistEditDetailForm>();
		TrgRecordListRegistEditDetailForm f1 = new TrgRecordListRegistEditDetailForm() {
			{setWeight("42"); setCount(17);}
		};
		TrgRecordListRegistEditDetailForm f2 = new TrgRecordListRegistEditDetailForm(){
			{setWeight("41.25"); setCount(17);}
		};
		TrgRecordListRegistEditDetailForm f3 = new TrgRecordListRegistEditDetailForm(){
			{setWeight("32.0"); setCount(17);}
		};
		list.add(f1);
		list.add(f2);
		list.add(f3);
		return list;
		
	}
	
	



//	public String getTrainingStartTime() {
//		return trainingStartTime;
//	}
//
//	public void setTrainingStartTime(String trainingStartTime) {
//		this.trainingStartTime = trainingStartTime;
//	}
	
	public String getEventsNameId() {
		return eventsNameId;
	}

	public void setEventsNameId(String eventsNameId) {
		this.eventsNameId = eventsNameId;
	}

	public void setTrainingStartTime(LocalDateTime trainingStartTime) {
		this.trainingStartTime = trainingStartTime;
	}
	
	public void setDetailForms(List<TrgRecordListRegistEditDetailForm> detailForms) {
		this.detailForms = detailForms;
	}

	public List<TrgRecordListRegistEditDetailForm> getDetailForms() {
		return detailForms;
	}

	public LocalDateTime getTrainingStartTime() {
		return trainingStartTime;
	}
}