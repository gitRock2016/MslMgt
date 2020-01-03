package com.iwatakhr.mslmgt.application;

import java.util.ArrayList;
import java.util.List;

import com.iwatakhr.mslmgt.application.dto.TrgRecordListDto;


public class TrgRecordListApplication {

	public List<TrgRecordListDto> show() {
		
		
		
		return mock1();
	}
	
	// TODO mock
	ArrayList<TrgRecordListDto> mock1(){
		TrgRecordListDto d1 = new TrgRecordListDto() {
			{
				setEventsName("ペクトラル");
				setTrainingStartTime("2019/12/1 15:36");
			}
		};
		TrgRecordListDto d2 = new TrgRecordListDto() {
			{
				setEventsName("二頭筋");
				setTrainingStartTime("'2019/12/1 14:36");
			}
		};
		ArrayList<TrgRecordListDto> list = new ArrayList<TrgRecordListDto>();
		list.add(d1);
		list.add(d2);
		
		return list;
	}
}
