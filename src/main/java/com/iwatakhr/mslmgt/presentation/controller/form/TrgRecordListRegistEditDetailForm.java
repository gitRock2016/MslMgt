package com.iwatakhr.mslmgt.presentation.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TrgRecordListRegistEditDetailForm {
	
	// TODO 単項目チェックをいれたい
	@NotBlank
	private String weight;
	@NotNull
	private Integer count;

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

}
