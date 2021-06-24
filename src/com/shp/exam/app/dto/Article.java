package com.shp.exam.app.dto;

public class Article {
	public int id;
	public String regDate;
	public String updateDate;
	public String title;
	public String body;

	@Override
	public String toString() {
		return "Article [id=" + id + ", regDate=" + regDate + ", updateDate=" + updateDate + ", title=" + title
				+ ", body=" + body + "]";
	}
}
