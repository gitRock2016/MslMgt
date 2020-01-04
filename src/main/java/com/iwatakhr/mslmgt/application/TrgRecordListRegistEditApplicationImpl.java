package com.iwatakhr.mslmgt.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iwatakhr.mslmgt.application.dto.TrgRecordDetailDto;
import com.iwatakhr.mslmgt.application.dto.TrgRecordListRegistEditDto;

@Service
public class TrgRecordListRegistEditApplicationImpl implements TrgRecordListRegistEditApplication{
	
	/**
	 * 編集時に呼び出す
	 */
	@Override
	public TrgRecordListRegistEditDto show() {
		return mock1();
	}
	
	// TODO mock
	TrgRecordListRegistEditDto mock1() {
		TrgRecordListRegistEditDto dto = new TrgRecordListRegistEditDto();
		dto.setEventsName("2頭金");
		dto.setTrainingStartTime("2019 /12/1 4:22:11");
		
		List<TrgRecordDetailDto> detailList=new ArrayList<TrgRecordDetailDto>();
		TrgRecordDetailDto e1=new TrgRecordDetailDto();
		e1.setSeq(1); e1.setWeight("42.5"); e1.setTrainingCount(15);
		TrgRecordDetailDto e2=new TrgRecordDetailDto();
		e2.setSeq(2); e1.setWeight("32.5"); e2.setTrainingCount(15);
		detailList.add(e1);
		TrgRecordDetailDto e3=new TrgRecordDetailDto();
		e3.setSeq(3); e1.setWeight("30.5"); e3.setTrainingCount(15);
		detailList.add(e1);
		detailList.add(e2);
		detailList.add(e3);
		dto.setDetailList(detailList);
		
		return dto;
	}
	

}
