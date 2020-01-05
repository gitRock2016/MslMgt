package com.iwatakhr.mslmgt.application;


import com.iwatakhr.mslmgt.application.dto.TrgRecordListRegistEditDto;

public interface TrgRecordListRegistEditApplication {
	TrgRecordListRegistEditDto show();
	void regist(TrgRecordListRegistEditDto dto);
}
