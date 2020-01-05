package com.iwatakhr.mslmgt.mock;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * モック用
 * <br>
 * ログイン時にセッションに認証情報を格納し処理を制御したいが作成はあとにするため、モックで代用する
 * @author rock
 *
 */
public class MockValue {
	/* 個人情報IDは岩田を利用する */
	public static final Integer PERSONALID = 1;
	
	/* トレーニング記録登録画面などの種目リストの中身、個人情報ID=岩田に対応した内容*/
	public static final Map<String, String> EventsName_SelectList = new LinkedHashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("100", "ペクトラル");
			put("101", "上腕3頭筋");
		}
	};
	
}
