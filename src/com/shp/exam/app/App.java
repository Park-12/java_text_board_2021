package com.shp.exam.app;

import java.util.Scanner;

import com.shp.exam.app.dto.Article;

public class App {

	public static void run() {
		System.out.println("== 코틀린 텍스트 게시판 시작 ==");
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("명령어) ");
			String command = sc.nextLine().trim();
			
			if (command.equals("/usr/article/write")) {
				System.out.print("제목 : ");
				String title = sc.nextLine().trim();
				System.out.print("내용 : ");
				String body = sc.nextLine().trim();
				
				Article article = new Article();
				article.id = 1;
				article.regDate = "2021-06-24 12:12:12";
				article.updateDate = "2021-06-24 12:12:12";
				article.title = title;
				article.body = body;
				System.out.println(article);
				break;
			}
			
			if (command.equals("/usr/system/exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		System.out.println("== 코틀린 텍스트 게시판 끝 ==");
	}

}
