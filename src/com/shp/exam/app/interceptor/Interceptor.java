package com.shp.exam.app.interceptor;

import com.shp.exam.app.Rq.Rq;

public interface Interceptor {
	boolean run(Rq rq);
}
