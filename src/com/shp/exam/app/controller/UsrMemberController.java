package com.shp.exam.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.shp.exam.app.Rq.Rq;
import com.shp.exam.app.container.Container;
import com.shp.exam.app.dto.Member;
import com.shp.exam.util.Util;

public class UsrMemberController extends Controller {
	private List<Member> members;
	private int membersLastId;
	private Scanner sc;

	public UsrMemberController() {
		sc = Container.getSc();
		members = new ArrayList<>();
		membersLastId = 0;

		// 테스트 게시물
		makeTestDate();
	}

	private void makeTestDate() {
		for (int i = 0; i < 2; i++) {
			Member member = new Member();
			member.setId(membersLastId + 1);
			member.setRegDate(Util.getNowDateStr());
			member.setUpdateDate(Util.getNowDateStr());
			member.setLoginId("user" + member.getId());
			member.setLoginPw(member.getLoginId());
			member.setName("홍길동" + member.getId());
			member.setNickname("강바람" + member.getId());

			members.add(member);
			membersLastId++;
		}
	}

	private Member getMemberByLoginId(String loginId) {
		for (Member member : members) {
			if (member.getLoginId().equals(loginId)) {
				return member;
			}
		}
		return null;
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

		Member member = getMemberByLoginId(loginId);

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
