package com.tecsoon.ims.util;

import java.util.List;

public class PageResult {
	private Page page;		//分页信息
	@SuppressWarnings("rawtypes")
	private List list;		//记录信息
	public PageResult(Page page, @SuppressWarnings("rawtypes") List list) {
		this.page = page;
		this.list = list;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	public void setList(@SuppressWarnings("rawtypes") List list) {
		this.list = list;
	}
}
