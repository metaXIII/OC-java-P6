package com.metaxiii.escalade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CommentaireDto {
	private int    id;
	private Date   date;
	private String content;
}
