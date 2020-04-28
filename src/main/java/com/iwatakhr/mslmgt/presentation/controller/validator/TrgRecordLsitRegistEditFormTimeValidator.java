package com.iwatakhr.mslmgt.presentation.controller.validator;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iwatakhr.mslmgt.presentation.controller.form.TrgRecordListRegistEditForm;

/**
 * 相関チェックの動作検証用に作成
 * @author rock
 *
 */
@Component
public class TrgRecordLsitRegistEditFormTimeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TrgRecordListRegistEditForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasFieldErrors("trainingStartTime") ) {
            return;
        }
		
		System.out.println("validtor");
		
		TrgRecordListRegistEditForm f = (TrgRecordListRegistEditForm) target;
		LocalDateTime now = LocalDateTime.now();
		if(now.isAfter(f.getTrainingStartTime())) {
			errors.rejectValue("trainingStartTime", "Check1.TrgRecordListRegistEditForm.trainingStartTime", "過去の時間は入力できません");
		}
	}
	
}
