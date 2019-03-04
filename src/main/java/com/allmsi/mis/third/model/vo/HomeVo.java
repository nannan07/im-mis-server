package com.allmsi.mis.third.model.vo;

public class HomeVo {
	
	private Integer urgentCount;
	
	private Integer todoCount;
	
	private Integer allCount;
	
	private Object list;
	
	public HomeVo() {
	}
	
	public HomeVo(Integer urgentCount, Integer todoCount, Integer allCount, Object list) {
		this.urgentCount = urgentCount;
		this.todoCount = todoCount;
		this.allCount = allCount;
		this.list = list;
	}



	public Integer getUrgentCount() {
		return urgentCount;
	}

	public void setUrgentCount(Integer urgentCount) {
		this.urgentCount = urgentCount;
	}

	public Integer getTodoCount() {
		return todoCount;
	}

	public void setTodoCount(Integer todoCount) {
		this.todoCount = todoCount;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

}
