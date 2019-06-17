package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
<<<<<<< HEAD
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	

	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	
	public void testInsert(){
		BoardVO board = new BoardVO();
		board.setTitle("New post");
		board.setContent("New content");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board);
	}
	
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("New post : select key");
		board.setContent("New content : select key");
		board.setWriter("newbie");
		
		mapper.insertSelectKey(board);
		
		log.info(board);
	}
	
	public void testRead(){
		BoardVO board = mapper.read(5L);
		
		log.info(board);
	}
	
	public void testDelete() {
		log.info("Delete count : " + mapper.delete(3L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		
		board.setBno(2L);
		board.setTitle("hi!");
		board.setContent("yea!");
		board.setWriter("hoi");
		
		int count = mapper.update(board);
		log.info("Update count : " + count);
=======

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
>>>>>>> branch 'master' of https://github.com/TrianglePoint/devfox-java.git
	}

}
