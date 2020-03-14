package com.iwatakhr.mslmgt.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iwatakhr.mslmgt.application.dto.TrgRecordDetailDto;
import com.iwatakhr.mslmgt.application.dto.TrgRecordListRegistEditDto;
import com.iwatakhr.mslmgt.infrastructure.repository.TrgRecordRepository;
import com.iwatakhr.mslmgt.mock.MockValue;

@Service
public class TrgRecordListRegistEditApplicationImpl implements TrgRecordListRegistEditApplication{
	
	TrgRecordRepository trgRecordRepository;
	
	public TrgRecordListRegistEditApplicationImpl(TrgRecordRepository trgRecordRepository) {
		super();
		this.trgRecordRepository = trgRecordRepository;
	}

	/**
	 * 編集時に呼び出す
	 */
	@Override
	public TrgRecordListRegistEditDto show() {
		return show_mock1();
	}
	
	// TODO mock
	TrgRecordListRegistEditDto show_mock1() {
		TrgRecordListRegistEditDto dto = new TrgRecordListRegistEditDto();
		dto.setEventsNameId("2頭金");
//		dto.setTrainingStartTime("2019 /12/1 4:22:11");
		dto.setTrainingStartTime(LocalDateTime.of(2019,12,1,4,22,11));
		
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

	@Override
	public void regist(TrgRecordListRegistEditDto dto) {
		// training_recordsテーブルへ登録
		Integer training_record_id = trgRecordRepository.countMaxTrgReocords() + 1;
		// TODO 個人情報IDはログイン情報から取得できるようにする
		Integer personal_id = MockValue.PERSONALID; 
		LocalDateTime training_start_time = dto.getTrainingStartTime();
		// TODO eventsNameIdはIntegerで統一したい
		Integer training_events_id=Integer.parseInt(dto.getEventsNameId());
		LocalDateTime system_insert_time=LocalDateTime.now();
		LocalDateTime  sysytem_update_time=LocalDateTime.now();
		trgRecordRepository.insertTrainingRecords(
				  training_record_id
				, personal_id
				, training_start_time
				, training_events_id
				, system_insert_time
				, sysytem_update_time);
		
		// training_record_detailテーブルへ登録
		if (dto.getDetailList().size() > 0) {
			int seq = 1;
			for (TrgRecordDetailDto d : dto.getDetailList()) {
				// TODO 相関チェックはあとでつくるので、応急処理のチェックをいれる
				if (checkIsEmptyDto(d)) {
					trgRecordRepository.insertTrainingRecordDetail(
							  training_record_id
							, seq++
							, new BigDecimal(d.getWeight())
							, d.getTrainingCount()
							, system_insert_time
							, sysytem_update_time
					);
				}
			}
		}
	}
	
	/**
	 * TrgRecordDetailDtoに登録すべき情報があるかどうかチェックする
	 * 
	 * @param d
	 * @return 登録する情報がある場合はTRUEを返却する
	 */
	private boolean checkIsEmptyDto(TrgRecordDetailDto d) {
		return ( ! "".equals(d.getWeight()) && !(d.getTrainingCount() == null)); 
	}
	
	
	// TODO mock
	private void regist_mock1() {
		// training_recordsテーブルへ登録
		Integer training_record_id=trgRecordRepository.countMaxTrgReocords()+1;
//		Integer training_record_id=100;
		Integer personal_id=MockValue.PERSONALID; // 岩田
		LocalDateTime training_start_time = LocalDateTime.of(LocalDate.of(2019, 12, 1), LocalTime.of(12, 43));
		Integer training_events_id=100; // ペクトラル
		LocalDateTime system_insert_time=LocalDateTime.now();
		LocalDateTime  sysytem_update_time=LocalDateTime.now();
//		String weight="35.12";
		BigDecimal weight=BigDecimal.valueOf(35.12);
		Integer count=15;

		trgRecordRepository.insertTrainingRecords(
				  training_record_id
				, personal_id
				, training_start_time
				, training_events_id
				, system_insert_time
				, sysytem_update_time);
		// training_record_detailテーブルへ登録
		Integer[] seqs= {1,2,3};
		for(int seq : seqs) {
			trgRecordRepository.insertTrainingRecordDetail(
					training_record_id
					, seq
					, weight
					, count
					, system_insert_time
					, sysytem_update_time);
		}
	}

}
