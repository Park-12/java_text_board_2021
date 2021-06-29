package com.shp.exam.app.service;

import java.util.List;

import com.shp.exam.app.container.Container;
import com.shp.exam.app.dto.Article;
import com.shp.exam.app.repository.ArticleRepository;

public class ArticleService {
	private ArticleRepository articleRepository;

	public ArticleService() {
		articleRepository = Container.getArticleRepository();
	}

	public int write(int boradId, int memberId, String title, String body) {
		return articleRepository.write(boradId, memberId, title, body);
	}

	public Article getArticleById(int id) {
		return articleRepository.getArticleById(id);
	}

	public void deleteArticleById(int id) {
		articleRepository.deleteArticleById(id);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public void makeTestData() {
		for (int i = 0; i < 10; i++) {
			String title = "제목 " + (i + 1);
			String body = "내용 " + (i + 1);
			write(1, 1, title, body);
		}
	}
}
