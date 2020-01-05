package com.iwatakhr.mslmgt.presentation.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iwatakhr.mslmgt.application.TrgRecordListRegistEditApplication;
import com.iwatakhr.mslmgt.application.dto.TrgRecordDetailDto;
import com.iwatakhr.mslmgt.application.dto.TrgRecordListRegistEditDto;
import com.iwatakhr.mslmgt.presentation.controller.form.TrgRecordListRegistEditDetailForm;
import com.iwatakhr.mslmgt.presentation.controller.form.TrgRecordListRegistEditForm;

@Controller
@EnableAutoConfiguration
@RequestMapping("/TrgRecordListRegistEdit")
public class TrgRecordListRegistEditController {
	

	TrgRecordListRegistEditApplication trgRecordListRegistEditApplication;
	
	public TrgRecordListRegistEditController(TrgRecordListRegistEditApplication trgRecordListRegistEditApplication) {
		super();
		this.trgRecordListRegistEditApplication = trgRecordListRegistEditApplication;
	}

	final static Map<String, String> EventsName_SelectList = new LinkedHashMap<String, String>() {
		{
			put("100", "ペクトラル");
			put("101", "上腕3頭筋");
		}
	};

	/**
	 * 初期表示
	 * @param name
	 * @param model
	 * @return
	 */
	@GetMapping("/show")
	public String show(TrgRecordListRegistEditForm form, Model model) {
		
		// TODO mockデータ
//		form = new TrgRecordListRegistEditForm();
		
		model.addAttribute("trgRecordListRegistEdit", new TrgRecordListRegistEditForm());
		model.addAttribute("EventsName_SelectList", EventsName_SelectList);
		return "/mslmgt/trgRecordListRegistEdit";
	}

	/**
	 * 初期表示
	 * @param name
	 * @param model
	 * @return
	 */
	@PostMapping("/regist")
	public String regist(TrgRecordListRegistEditForm form, Model model) {
		
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
		
		// TODO formを利用してデータを登録する
		trgRecordListRegistEditApplication.regist(dto);
		return "redirect:/TrgRecordList/show";
	}
	
}