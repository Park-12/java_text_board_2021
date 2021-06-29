package com.shp.exam.app.controller;

import java.util.Scanner;

import com.shp.exam.app.Rq.Rq;
import com.shp.exam.app.container.Container;
import com.shp.exam.app.dto.Member;
import com.shp.exam.app.service.MemberService;
import com.shp.exam.util.Util;

public class UsrMemberController extends Controller {
	private Scanner sc;
	private MemberService memberService;

	public UsrMemberController() {
		sc = Container.getSc();
		memberService = Container.getMemberService();
		
		// 테스트 게시물
		memberService.makeTestDate();
	}

	@Override
	public void performAction(Rq rq) {
		if (rq.getActionPath().equals("/usr/member/login")) {
			actionLogin(rq);
		} else if (rq.getActionPath().equals("/usr/member/logout")) {
			actionLogout(rq);
		}
	}

	private void actionLogout(Rq rq) {
		rq.logout();

	}

	private void actionLogin(Rq rq) {
		System.out.printf("로그인아이디 : ");
		String loginId = sc.nextLine().trim();

		if (loginId.length() == 0) {
			System.out.println("로그인아이디를 입력해주세요.");
			return;
		}

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			System.out.println("해당 회원은 존재하지 않습니다.");
			return;
		}

		System.out.printf("로그인비밀번호 : ");
		String loginPw = sc.nextLine().trim();

		if (loginPw.length() == 0) {
			System.out.println("로그인비밀번호를 입력해주세요.");
			return;
		}

		if (member.getLoginPw().equals(loginPw) == false) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}

		rq.login(member);

		System.out.printf("%s님 환영합니다.\n", member.getNickname());
	}
}
