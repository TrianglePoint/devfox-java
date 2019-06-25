package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		final double DECIMAL_POINT_MOVE_ONCE = 10.0; 
		final int MAX_PAGE_THE_CAN_SEE = 10;
		final double CHANGE_TO_DOUBLE = 1.0;
		
		int realEnd;
		
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / DECIMAL_POINT_MOVE_ONCE) * 
						MAX_PAGE_THE_CAN_SEE);
		
		this.startPage = this.endPage - MAX_PAGE_THE_CAN_SEE + 1;
		
		realEnd = (int) (Math.ceil((total * CHANGE_TO_DOUBLE) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
}
