package org.yan.mewtwo.controller;

public class PractiseController extends BaseController {
	
	public void index(){
		
	}
	
	public void list(){
		setAttr("titleName", "推荐阅读");
		render(getViewPath() + "practise/list.html");
	}
}
