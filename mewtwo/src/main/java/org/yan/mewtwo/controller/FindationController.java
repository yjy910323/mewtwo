package org.yan.mewtwo.controller;

public class FindationController extends BaseController {
	
	public void index(){
		render(getViewPath() + "findation/preference.html");
	}
	
	public void preference(){
		redirect("/findation");
	}
	
	public void practise(){
		render(getViewPath() + "findation/practise.html");
	}
}
