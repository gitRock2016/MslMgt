package com.iwatakhr.mslmgt.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iwatakhr.mslmgt.application.dto.TrgRecordListDto;
import com.iwatakhr.mslmgt.infrastructure.entity.TrgRecordEntity;
import com.iwatakhr.mslmgt.infrastructure.repository.TrgRecordRepository;
import com.iwatakhr.mslmgt.mock.MockValue;

@Service
public class TrgRecordListApplicationImpl implements TrgRecordListApplication{
	
	TrgRecordRepository trgRecordRepo;

	public TrgRecordListApplicationImpl(TrgRecordRepository trgRecordRepo) {
		super();
		this.trgRecordRepo = trgRecordRepo;
	}

	@Override
	public List<TrgRecordListDto> show() {
		// TODO ログイン時の認証情報から個人情報を取得したい
		List<TrgRecordEntity> entityList= trgRecordRepo.findByPersonalId(MockValue.PERSONALID);
		List<TrgRecordListDto> arrayList = new ArrayList<TrgRecordListDto>();
		for(TrgRecordEntity en : entityList) {
			TrgRecordListDto d = new TrgRecordListDto();
			// TODO eventsNameIdはInteger型で扱いたい
			d.setEventsNameId(String.valueOf(en.getTraining_events_id()));
			// TODO formにあわせLocalDateTimeでマッピングしたい
			LocalDateTime _t = en.getTraining_start_time();
			d.setTrainingStartTime(_t.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
			arrayList.add(d);
		}
		return arrayList;
//		return mock2();
//		return mock1();
	}
	
	
	
	// TODO mock
	List<TrgRecordListDto> mock2(){

		List<TrgRecordEntity> entityList = trgRecordRepo.findByPersonalId(MockValue.PERSONALID);
		List<TrgRecordListDto> arrayList = new ArrayList<TrgRecordListDto>();
		for(TrgRecordEntity en : entityList) {
			TrgRecordListDto d = new TrgRecordListDto();
			d.setEventsNameId(String.valueOf(en.getTraining_events_id()));
			LocalDateTime _t = en.getTraining_start_time();
			d.setTrainingStartTime(_t.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss")));
			arrayList.add(d);
		}
		return arrayList;
	}
	
	ArrayList<TrgRecordListDto> mock1(){
		TrgRecordListDto d1 = new TrgRecordListDto() {
			{
				setEventsNameId("ペクトラル");
				setTrainingStartTime("2019/12/1 15:36");
			}
		};
		TrgRecordListDto d2 = new TrgRecordListDto() {
			{
				setEventsNameId("二頭筋");
				setTrainingStartTime("'2019/12/1 14:36");
			}
		};
		ArrayList<TrgRecordListDto> list = new ArrayList<TrgRecordListDto>();
		list.add(d1);
		list.add(d2);
		
		return list;
	}
}
