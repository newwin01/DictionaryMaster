package com.jsc.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordCRUD implements ICRUD{
	ArrayList<Word> list;
	Scanner s;
	final String fname = "dic.txt";


	WordCRUD(Scanner s) {
		list = new ArrayList<>();
		this.s = s;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Object add() {
		System.out.print("난이도(1,2,3) & 새 단어 입력 : ");
		int level = s.nextInt();
		String word = s.nextLine();
		System.out.print("뜻 입력: ");
		String meaning = s.nextLine();
		// TODO Auto-generated method stub
		return new Word(0,level, word, meaning);
	}

	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("단어가 단어장에 추가 되었습니다. ");
	}

	public void listAll() {
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("------------------------");
	}
	//Listing certain words
	public ArrayList<Integer> listAll(String keyword) {
		int number = 0;
		ArrayList<Integer> idList = new ArrayList<>();
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			String word = list.get(i).getWord();
			if(!word.contains(keyword)) continue;
			System.out.print((number+1) + " ");
			System.out.println(list.get(i).toString());
			idList.add(i);
			number++;
		}
		System.out.println("------------------------");
		return idList;
	}
	public void updateItem() {
		System.out.print("==> 수정할 단어 검색: ");
		String keyword = s.next();
		ArrayList<Integer> idList = this.listAll(keyword);
		System.out.print("==> 수정할 번호 선택: ");
		int num = s.nextInt();
		s.nextLine();
		System.out.print("=> 뜻 입력: ");
		String meaning = s.nextLine();
		Word word = list.get(idList.get(num-1));
		word.setMeaning(meaning);
		System.out.println("단어가 수정이 되었습니다. ");
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


	public void deleteItem() {
		System.out.print("==> 삭제할 단어 검색: ");
		String keyword = s.next();
		ArrayList<Integer> idList = this.listAll(keyword);
		System.out.print("==> 삭제할 번호 선택: ");
		int num = s.nextInt();
		s.nextLine();


		System.out.print("=> 정말로 삭제하시겠습니까?(Y/N) ");
		String answer = s.next();
		if (answer.equalsIgnoreCase("y")) {
			list.remove((int)idList.get(num - 1));
			System.out.println("단어가 삭제되었습니다. ");
		} else {
			System.out.println("취소되었습니다. ");
		}
	}

	public void saveFile() {

	}

	public void loadFile(){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fname));
			String line;
			int count=0;
			while(true) {
				line = br.readLine();
				if(line==null) break;
				String data[] = line.split("\\|");
				int level = Integer.parseInt(data[0]);
				String word = data[1];
				String meaning = data[2];
				list.add(new Word(count,level,word,meaning));
				count++;
			}
			br.close();
			System.out.println("==>"+count+" 개 로딩 완료!");

		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다!");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}