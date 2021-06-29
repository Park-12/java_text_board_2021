package com.shp.exam.app.service;

import com.shp.exam.app.container.Container;
import com.shp.exam.app.dto.Board;
import com.shp.exam.app.repository.BoardRepository;

public class BoardService {

	private BoardRepository boardRepository;
	
	public BoardService() {
		boardRepository = Container.getBoardRepository();
	}

	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
	
}
