package com.iwatakhr.mslmgt.infrastructure.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.iwatakhr.mslmgt.infrastructure.entity.TrgRecordEntity;

@Repository
@Mapper
public interface TrgRecordRepository {
		
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
		List<TrgRecordEntity> findByTrgRecordId(Integer trgRecordId);
	
	/**
	 * findByTrgRecordId」と条件が違うだけ、他は同じ。
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

	//	@Select("select "
//			 + " training_record_id"
//			 + ",training_start_time"
//			 + ",training_events_id"
//			 + " from mslmgt.training_records"
//			 + " where training_record_id = #{id}")

	
}
