package com.shp.exam.app.container;

import java.util.Scanner;

import com.shp.exam.app.Session;
import com.shp.exam.app.controller.UsrArticleController;
import com.shp.exam.app.controller.UsrMemberController;
import com.shp.exam.app.controller.UsrSystemController;
import com.shp.exam.app.interceptor.NeedLoginInterceptor;
import com.shp.exam.app.interceptor.NeedLogoutInterceptor;
import com.shp.exam.app.repository.ArticleRepository;
import com.shp.exam.app.repository.BoardRepository;
import com.shp.exam.app.repository.MemberRepository;
import com.shp.exam.app.service.ArticleService;
import com.shp.exam.app.service.BoardService;
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
	private static BoardRepository boardRepository;
	@Getter
	private static ArticleRepository articleRepository;
	
	@Getter
	private static MemberService memberService;
	@Getter
	private static BoardService boardService;
	@Getter
	private static ArticleService articleService;
	
	@Getter
	private static NeedLoginInterceptor needLoginInterceptor;
	@Getter
	private static NeedLogoutInterceptor needLogoutInterceptor;
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
		boardRepository = new BoardRepository();
		articleRepository = new ArticleRepository();

		memberService = new MemberService();
		boardService = new BoardService();
		articleService = new ArticleService();
		
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();

		usrSystemController = new UsrSystemController();
		usrMemberController = new UsrMemberController();
		usrArticleController = new UsrArticleController();
	}
}