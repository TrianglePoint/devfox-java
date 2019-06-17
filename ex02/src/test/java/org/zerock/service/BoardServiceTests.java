package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("new post");
		board.setContent("new content");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("Number of created post : " + board.getBno());
	}
	
	public void testGetList() {
		service.getList().forEach(board -> log.info(board));
	}
	
	public void testGet() {
		log.info(service.get(1L));
	}
	
	@Test
	public void testDelete() {
		log.info("Remove result : " + service.remove(25L));
	}
	
	public void testUpdate() {
		BoardVO board = service.get(1L);
		
		if(board == null) {
			return;
		}
		
		board.setTitle("Modify the title");
		log.info("Modify result : " + service.modify(board));
	}
}
