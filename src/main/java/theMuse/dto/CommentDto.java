package theMuse.dto;

import lombok.Data;

@Data
public class CommentDto {
	private int commentIdx;
	private String commentContent;
	private String commentDt;
	//Todo private String commentStarCt;
	private int commentUserIdx;
	private int commentMusicalIdx;
}
