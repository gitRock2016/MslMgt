package com.iwatakhr.mslmgt.infrastructure.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.iwatakhr.mslmgt.infrastructure.entity.TrgRecordEntity;

@Repository
@Mapper
public interface TrgRecordMapper {
	List<TrgRecordEntity> findById(Integer personalId);
	TrgRecordEntity findSampleById(int id);
}
