package com.iwatakhr.mslmgt.presentation.controller.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.iwatakhr.mslmgt.presentation.controller.form.TrgRecordListRegistEditDetailForm;

@Component
public class TrgRecordDetailFormsIsBlankValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return TrgRecordListRegistEditDetailForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TrgRecordListRegistEditDetailForm f = (TrgRecordListRegistEditDetailForm) target;
		String w = f.getWeight();
		Integer count = f.getCount();
		// TODO 相関チェックエラーの確認
		// 試しに必ずエラーになるよう修正してためす→エラーが表示されない
		errors.rejectValue("count", "TrgRecordListRegistEditDetailForm.count", "回数の値が入力されていません。");
		if(isW(w) && !isCount(count)){
			errors.rejectValue("count", "TrgRecordListRegistEditDetailForm.count", "回数の値が入力されていません。");
		}else if(!isW(w) && isCount(count)) {
			errors.rejectValue("weight", "TrgRecordListRegistEditDetailForm.weight", "重量の値が入力されていません。");
		}else {
			// 重量と回数ともに値が入っていない場合は、許容する
		}
		
	}
	
	private boolean isW(String w) {
		return  !StringUtils.isEmpty(w);
	}
	
	private boolean isCount(Integer count) {
		if(count==null)return false;
		if(count.equals(0))return false;
		return true;
	}

}
