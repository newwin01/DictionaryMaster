package com.jsc.dictionary;
//create function
public interface ICRUD {
	public Object add();
	public int update(Object obj);
	public int delete(Object obj);
	public void selectOne(int id);

}
