package com.jsc.dictionary;

import java.util.Scanner;

public class WordManager {
	Scanner s = new Scanner(System.in);
	WordCRUD wordCRUD;
	
	WordManager() {
		wordCRUD = new WordCRUD(s);
		// TODO Auto-generated constructor stub
	}
	
	public void start() {
		while(true) {
			int menu = selectMenu();
			if(menu==0) break;
			if(menu==4) {
				wordCRUD.addWord();
			}
			if(menu==1) {
				wordCRUD.listAll();
			}
		}
		
	}
	public int selectMenu() {
		System.out.println("*** ���ܾ� ������ ***\n"
				+"**********************\n"
				+"1. ��� �ܾ� ����\n"
				+"2. ���غ� �ܾ� ����\n"
				+"3. �ܾ� �˻�\n"
				+"4. �ܾ� �߰�\n"
				+"5. �ܾ� ����\n"
				+"6. �ܾ� ����\n"
				+"7. ���� ����\n"
				+"0. ������\n"
				+"**********************\n"
				+"=> ���ϴ� �޴���? ");
		return s.nextInt();
	}
}
