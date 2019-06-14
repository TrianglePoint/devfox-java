package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TodoDTO {
	private String title;
	private Date dueDate;
	
	@DateTimeFormat(pattern = "yy/MM/dd")
	private Date dueDate2;
}
