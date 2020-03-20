package com.iwatakhr.mslmgt.presentation.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iwatakhr.mslmgt.application.TrgRecordListRegistEditApplication;
import com.iwatakhr.mslmgt.application.dto.TrgRecordDetailDto;
import com.iwatakhr.mslmgt.application.dto.TrgRecordListRegistEditDto;
import com.iwatakhr.mslmgt.mock.MockValue;
import com.iwatakhr.mslmgt.presentation.controller.form.TrgRecordListRegistEditDetailForm;
import com.iwatakhr.mslmgt.presentation.controller.form.TrgRecordListRegistEditForm;

@Controller
@EnableAutoConfiguration
@RequestMapping("/TrgRecordListRegistEdit")
public class TrgRecordListRegistEditController {
	
	@Autowired
	MessageSource msg;
	
	TrgRecordListRegistEditApplication trgRecordListRegistEditApplication;
	
	public TrgRecordListRegistEditController(TrgRecordListRegistEditApplication trgRecordListRegistEditApplication) {
		super();
		this.trgRecordListRegistEditApplication = trgRecordListRegistEditApplication;
	}

	/**
	 * 初期表示
	 */
	@GetMapping("/show")
	public String show(TrgRecordListRegistEditForm form, Model model) {
		
		model.addAttribute("trgRecordListRegistEditForm", new TrgRecordListRegistEditForm());
		model.addAttribute("EventsName_SelectList", MockValue.EventsName_SelectList);
		return "/mslmgt/trgRecordListRegistEdit";
	}

	/**
	 * 初期表示
	 * @param name
	 * @param model
	 * @return
	 */
	@PostMapping("/regist")
	public String regist(@ModelAttribute @Validated TrgRecordListRegistEditForm form, BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("trgRecordListRegistEditForm", form);
			model.addAttribute("EventsName_SelectList", MockValue.EventsName_SelectList);
			return "/mslmgt/trgRecordListRegistEdit";
		}
		// form→dtoへマッピング
		TrgRecordListRegistEditDto dto =new TrgRecordListRegistEditDto();
		dto.setEventsNameId(form.getEventsNameId());
		dto.setTrainingStartTime(form.getTrainingStartTime());
		int seq=1;
		ArrayList<TrgRecordDetailDto> detailList = new ArrayList<TrgRecordDetailDto>();
		for(TrgRecordListRegistEditDetailForm  f : form.getDetailForms()) {
			TrgRecordDetailDto d=new TrgRecordDetailDto();
			d.setSeq(seq++);
			d.setWeight(f.getWeight());
			d.setTrainingCount(f.getCount());
			detailList.add(d);
		}
		dto.setDetailList(detailList);
		
		trgRecordListRegistEditApplication.regist(dto);
		
		return "redirect:/TrgRecordList/show";
	}
	
}