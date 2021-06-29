package com.shp.exam.app.container;

import java.util.Scanner;

import com.shp.exam.app.Session;
import com.shp.exam.app.controller.UsrArticleController;
import com.shp.exam.app.controller.UsrMemberController;
import com.shp.exam.app.controller.UsrSystemController;
import com.shp.exam.app.repository.ArticleRepository;
import com.shp.exam.app.service.ArticleService;

import lombok.Getter;

public class Container {
	@Getter
	private static Scanner sc;
	@Getter
	private static Session session;

	@Getter
	private static ArticleService articleService;
	@Getter
	private static ArticleRepository articleRepository;

	@Getter
	private static UsrSystemController usrSystemController;
	@Getter
	private static UsrArticleController usrArticleController;
	@Getter
	private static UsrMemberController usrMemberController;

	static {
		sc = new Scanner(System.in);
		session = new Session();

		articleRepository = new ArticleRepository();

		articleService = new ArticleService();

		usrSystemController = new UsrSystemController();
		usrArticleController = new UsrArticleController();
		usrMemberController = new UsrMemberController();
	}
}