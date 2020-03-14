package com.iwatakhr.mslmgt.infrastructure.entity;

import java.time.LocalDateTime;

public class TrgRecordEntity {

	private Integer training_record_id;
	private LocalDateTime training_start_time;
	private Integer training_events_id;
	private String events_name;
	private String part_name;

	public Integer getTraining_record_id() {
		return training_record_id;
	}

	public void setTraining_record_id(Integer training_record_id) {
		this.training_record_id = training_record_id;
	}

	public LocalDateTime getTraining_start_time() {
		return training_start_time;
	}

	public void setTraining_start_time(LocalDateTime training_start_time) {
		this.training_start_time = training_start_time;
	}

	public Integer getTraining_events_id() {
		return training_events_id;
	}

	public void setTraining_events_id(Integer training_events_id) {
		this.training_events_id = training_events_id;
	}

	public String getEvents_name() {
		return events_name;
	}

	public void setEvents_name(String events_name) {
		this.events_name = events_name;
	}

	public String getPart_name() {
		return part_name;
	}

	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}

}
