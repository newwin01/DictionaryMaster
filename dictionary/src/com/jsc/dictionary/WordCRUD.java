package com.jsc.dictionary;

import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRDUD{
	ArrayList<Word> list;
	Scanner s;
	
	
	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object add() {
		System.out.println("=> ���̵�(1,2,3) & �� �ܾ� �Է� : ");
		int level = s.nextInt();
		String word = s.nextLine();
		System.out.print("�� �Է� : ");
		String meaning = s.nextLine();
		
		// TODO Auto-generated method stub
		return new Word(0,level, word, meaning);
	}
	
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("�ܾ �ܾ��忡 �߰� �Ǿ����ϴ�.");
	}
	
	public void listAll() {
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("------------------------");
	}
	
	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectOne(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
