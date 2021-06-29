package com.shp.exam.app.container;

import java.util.Scanner;

import com.shp.exam.app.Session;
import com.shp.exam.app.controller.UsrArticleController;
import com.shp.exam.app.controller.UsrMemberController;
import com.shp.exam.app.controller.UsrSystemController;
import com.shp.exam.app.repository.ArticleRepository;
import com.shp.exam.app.repository.MemberRepository;
import com.shp.exam.app.service.ArticleService;
import com.shp.exam.app.service.MemberService;

import lombok.Getter;

public class Container {
	@Getter
	private static Scanner sc;
	@Getter
	private static Session session;

	@Getter
	private static MemberRepository memberRepository;
	@Getter
	private static ArticleRepository articleRepository;
	
	@Getter
	private static MemberService memberService;
	@Getter
	private static ArticleService articleService;
	
	@Getter
	private static UsrSystemController usrSystemController;
	@Getter
	private static UsrMemberController usrMemberController;
	@Getter
	private static UsrArticleController usrArticleController;

	static {
		sc = new Scanner(System.in);
		session = new Session();

		memberRepository = new MemberRepository();
		articleRepository = new ArticleRepository();

		memberService = new MemberService();
		articleService = new ArticleService();

		usrSystemController = new UsrSystemController();
		usrMemberController = new UsrMemberController();
		usrArticleController = new UsrArticleController();
	}
}