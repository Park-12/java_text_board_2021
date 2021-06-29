package com.shp.exam.app.interceptor;

import com.shp.exam.app.Rq.Rq;

public class NeedLoginInterceptor implements Interceptor {
	@Override
	public boolean run(Rq rq) {
		if (rq.isLogined()) {
			return true;
		}
		switch (rq.getActionPath()) {
		case "/usr/article/write":
		case "/usr/article/modify":
		case "/usr/article/delete":
			System.out.println("로그인 후 이용해주세요.");
			return false;
		}
		return true;
	}
}
