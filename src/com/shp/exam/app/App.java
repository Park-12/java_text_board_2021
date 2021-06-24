package com.shp.exam.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shp.exam.app.dto.Article;
import com.shp.exam.util.Util;

public class App {

	public static void run() {
		System.out.println("== 코틀린 텍스트 게시판 시작 ==");

		Scanner sc = new Scanner(System.in);

		List<Article> articles = new ArrayList<>();

		int articesLastId = 0;

		while (true) {
			System.out.print("명령어) ");
			String command = sc.nextLine().trim();

			if (command.equals("/usr/article/write")) {
				System.out.printf("제목 : ");
				String title = sc.nextLine().trim();
				System.out.printf("내용 : ");
				String body = sc.nextLine().trim();

				Article article = new Article();
				article.id = articesLastId + 1;
				article.regDate = Util.getNowDateStr();
				article.updateDate = Util.getNowDateStr();
				article.title = title;
				article.body = body;
				articles.add(article);

				articesLastId++;

				System.out.printf("%d번 게시물이 생성되었습니다.\n", article.id);

			} else if (command.equals("/usr/article/list")) {
				System.out.printf("번호 / 작성날짜 / 제목\n");

				for (int i = articles.size() - 1; i >= 0; i--) {
					Article article = articles.get(i);
					System.out.printf("%d / %s / %s\n", article.id, article.regDate, article.title);
				}
			} else if (command.equals("/usr/system/exit")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

		System.out.println("== 코틀린 텍스트 게시판 끝 ==");
	}

}
