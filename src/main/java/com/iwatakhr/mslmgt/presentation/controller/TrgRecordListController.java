package com.iwatakhr.mslmgt.presentation.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iwatakhr.mslmgt.application.TrgRecordListApplication;
import com.iwatakhr.mslmgt.application.dto.TrgRecordListDto;

@Controller
@EnableAutoConfiguration
@RequestMapping("/TrgRecordList")
public class TrgRecordListController {
	

	TrgRecordListApplication trgRecordApp;
	
	public TrgRecordListController(TrgRecordListApplication trgRecordApp) {
		this.trgRecordApp = trgRecordApp;
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
	@RequestMapping("/show")
	public String show(Model model) {
		List<TrgRecordListDto> trgRecordList = trgRecordApp.show();
		model.addAttribute("trgRecordList", trgRecordList);
		model.addAttribute("EventsName_SelectList", EventsName_SelectList);
		return "/mslmgt/trgRecordList";
	}

}