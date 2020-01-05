package com.iwatakhr.mslmgt.infrastructure.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.iwatakhr.mslmgt.infrastructure.entity.TrgRecordDetailEntity;
import com.iwatakhr.mslmgt.infrastructure.entity.TrgRecordEntity;

/**
 * トレーニング系のテーブルを扱う
 * 
 * <li>training_records
 * <li>training_record_detail
 * <li>training_events
 * @author rock
 *
 */
@Repository
@Mapper
public interface TrgRecordRepository {
	
	/**
	 * トレーニングレコードIDの最大値を取得する
	 * @return
	 */
	@Select("select max(training_record_id) from mslmgt.training_records")
	Integer countMaxTrgReocords();
	
	/**
	 * トレーニング記録IDより、トレーニング情報を取得する
	 * @param trgRecordId
	 * @return
	 */
	@Select("select"
			+"  trds.training_record_id "
			+ ",trds.training_start_time "
			+ ",tevs.training_events_id"
			+ ",tevs.events_name"
			+ ",pm.part_name"
			+" from mslmgt.training_records trds, mslmgt.training_events tevs, mslmgt.part_master pm"
			+"	 where"
			+ "       trds.training_events_id=tevs.training_events_id"
			+ " and tevs.part_id=pm.part_id"
			+ " and trds.training_record_id=#{trgRecordId}")
			TrgRecordEntity findByTrgRecordId(Integer trgRecordId);
	
	/**
	 * 個人情報IDより、トレーニング情報を取得する
	 * ※「findByTrgRecordId」と検索条件以外は同じ
	 * TODO 動的SQLを利用して、findByTrgRecordIdとメソッドを統一したい
	 * @param personalId
	 * @return
	 */
	@Select("select"
			+"  trds.training_record_id "
			+ ",trds.training_start_time "
			+ ",tevs.training_events_id"
			+ ",tevs.events_name"
			+ ",pm.part_name"
			+" from mslmgt.training_records trds, mslmgt.training_events tevs, mslmgt.part_master pm"
			+"	 where"
			+ "       trds.training_events_id=tevs.training_events_id"
			+ " and tevs.part_id=pm.part_id"
			+ " and trds.personal_id=#{personalId}")
		List<TrgRecordEntity> findByPersonalId(Integer personalId);
	
	// mslmgt.training_recordsテーブルへの登録処理
	@Insert("INSERT INTO mslmgt.training_records"
			+ "( training_record_id"
			+ ", personal_id"
			+ ", training_start_time"
			+ ", training_events_id"
			+ ", system_insert_time"
			+ ", sysytem_update_time)"
			+ " VALUES ("
			+ "  #{ training_record_id }"
			+ ", #{ personal_id }"
			+ ", #{ training_start_time }"
			+ ", #{ training_events_id }"
			+ ", #{ system_insert_time }"
			+ ", #{ sysytem_update_time })")
	int insertTrainingRecords(
			 Integer training_record_id
			,Integer personal_id
			,LocalDateTime training_start_time
			,Integer training_events_id
			,LocalDateTime system_insert_time
			,LocalDateTime sysytem_update_time);
	
	// mslmgt.training_record_detailテーブルへの登録処理
	@Insert("INSERT INTO mslmgt.training_record_detail"
			+ "( training_record_id"
			+ ", seq"
			+ ", weight"
			+ ", count"
			+ ", system_insert_time"
			+ ", sysytem_update_time)"
			+ " VALUES ("
			+ "  #{ training_record_id}"
			+ ", #{ seq }"
			+ ", #{ weight }"
			+ ", #{ count }"
			+ ", #{ system_insert_time }"
			+ ", #{ sysytem_update_time })")
	int insertTrainingRecordDetail(
			 Integer training_record_id
			,Integer seq
			,BigDecimal weight
			,Integer count
			,LocalDateTime system_insert_time
			,LocalDateTime  sysytem_update_time);
	
	// トレーニング記録詳細を取得する
	@Select("SELECT"
			+ "  trd.training_record_id"
			+ ", trd.seq"
			+ ", trd.weight"
			+ ", trd.count"
			+ ", trd.system_insert_time"
			+ ", trd.sysytem_update_time" 
			+ " FROM mslmgt.training_record_detail trd, mslmgt.training_records tr"
			+ " WHERE"
			+ "       trd.training_record_id = tr.training_record_id"
			+ " and tr.personal_id = #{personalId}"
			+ " ORDER BY training_record_id, seq")
	List<TrgRecordDetailEntity> findDetailByPersonalId(Integer personalId);
			
}
