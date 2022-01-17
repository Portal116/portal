package com.myproject.backendEx;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class BoardController {
	@RequestMapping("/guestbook")
	List<BoardDto> boardList() {
		List<BoardDto> list = new ArrayList<BoardDto>();
		list.add(new BoardDto("1", "write1", "title1", "content1"));
		list.add(new BoardDto("2", "write1", "eeee", "eeee"));
		list.add(new BoardDto("3", "write1", "eeee", "eeee"));
		list.add(new BoardDto("4", "write1", "eeee", "eeee"));
		list.add(new BoardDto("5", "write1", "eeee", "eeee"));
		list.add(new BoardDto("6", "write1", "eeee", "eeee"));
		list.add(new BoardDto("7", "write1", "eeee", "eeee"));

		return list;
	}
}
