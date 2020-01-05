package com.iwatakhr.mslmgt.infrastructure.entity;

import java.time.LocalDateTime;

public class TrgRecordDetailEntity {

	private Integer training_record_id;
	private Integer seq;
	private String weight;
	private Integer count;
	private LocalDateTime system_insert_time;
	private LocalDateTime sysytem_update_time;

	public Integer getTraining_record_id() {
		return training_record_id;
	}

	public void setTraining_record_id(Integer training_record_id) {
		this.training_record_id = training_record_id;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public LocalDateTime getSystem_insert_time() {
		return system_insert_time;
	}

	public void setSystem_insert_time(LocalDateTime system_insert_time) {
		this.system_insert_time = system_insert_time;
	}

	public LocalDateTime getSysytem_update_time() {
		return sysytem_update_time;
	}

	public void setSysytem_update_time(LocalDateTime sysytem_update_time) {
		this.sysytem_update_time = sysytem_update_time;
	}

}
