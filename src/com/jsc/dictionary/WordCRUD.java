package com.jsc.dictionary;

import java.io.*;
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

	@Override
	public void addWord() {
		Word one = (Word)add();
		list.add(one);
		System.out.println("단어가 단어장에 추가 되었습니다. ");
	}
	@Override
	public void listAll() {
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			System.out.print((i+1) + " ");
			System.out.println(list.get(i).toString());
		}
		System.out.println("------------------------");
	}
	@Override
	public void listAll(int level) {
		int j=0;
		System.out.println("------------------------");
		for(int i=0;i<list.size();i++) {
			int iLevel = list.get(i).getLevel();
			if(iLevel!=level) continue;
			System.out.print((j+1)+" ");
			System.out.println(list.get(i).toString());
			j++;
		}
		System.out.println("------------------------");
	}
	//Listing certain words
	@Override
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
	@Override
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
	@Override
	public void saveFile() {
		try {
			PrintWriter pr = new PrintWriter(new FileWriter(fname));
			for(Word data:list){
				pr.write(data.toFileString()+"\n");
			}
			pr.close();
			System.out.println("파일 저장이 완료되었습니다. ");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	@Override
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
	@Override
	public void searchLevel() {
		System.out.print("=> 원하는 레벨은? (1~3): ");
		int level=s.nextInt();
		listAll(level);
	}
	@Override
	public void searchWord() {
		System.out.print("=> 원하는 단어는?: ");
		String word=s.next();
		listAll(word);
	}
}