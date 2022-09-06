package com.jsc.dictionary;

import java.util.ArrayList;

//create function
public interface ICRUD {
	public Object add();
	public void addWord();
	public void listAll();
	public void listAll(int level);

	//Listing certain words
	public ArrayList<Integer> listAll(String keyword);

	public void updateItem();

	public void deleteItem();

	public void saveFile();

	public void loadFile();

	public void searchLevel();

	public void searchWord();
}
