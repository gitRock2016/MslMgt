package com.iwatakhr.mslmgt.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import com.iwatakhr.mslmgt.application.dto.TrgRecordListDto;
import com.iwatakhr.mslmgt.infrastructure.entity.TrgRecordEntity;
import com.iwatakhr.mslmgt.infrastructure.repository.TrgRecordMapper;
import com.iwatakhr.mslmgt.infrastructure.repository.TrgRecordRepository;

@Service
public class TrgRecordListApplicationImpl implements TrgRecordListApplication{
	
	TrgRecordRepository trgRecordRepo;
	// TODO 実験用
	TrgRecordMapper trgRecordMapper;

//	public TrgRecordListApplicationImpl(TrgRecordRepository trgRecordRepo) {
//		this.trgRecordRepo = trgRecordRepo;
//	}
	public TrgRecordListApplicationImpl(TrgRecordRepository trgRecordRepo, TrgRecordMapper trgRecordMapper) {
		super();
		this.trgRecordRepo = trgRecordRepo;
		this.trgRecordMapper = trgRecordMapper;
	}



	@Override
	public List<TrgRecordListDto> show() {
		
		
// TODO 実験用
//		TrgRecordEntity e =trgRecordRepo.findSampleById(1);
//		TrgRecordEntity e2 =trgRecordMapper.findSampleById(1);
//		int c =trgRecordRepo.count();
		
		return mock2();
//		return mock1();
	}
	
	// TODO mock
	List<TrgRecordListDto> mock2(){

		List<TrgRecordEntity> entityList = trgRecordRepo.findById(1);
		List<TrgRecordListDto> arrayList = new ArrayList<TrgRecordListDto>();
		for(TrgRecordEntity en : entityList) {
			TrgRecordListDto d = new TrgRecordListDto();
			d.setEventsName(en.getEvents_name());
			LocalDateTime _t = en.getTraining_start_time();
			d.setTrainingStartTime(_t.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
			arrayList.add(d);
		}
		return arrayList;
	}
	
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
