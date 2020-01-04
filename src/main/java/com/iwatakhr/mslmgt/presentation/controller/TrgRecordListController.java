package com.iwatakhr.mslmgt.presentation.controller;

import java.util.List;

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
		return "/mslmgt/trgRecordList";
	}

}