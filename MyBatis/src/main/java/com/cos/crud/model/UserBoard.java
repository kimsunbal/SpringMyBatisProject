package com.cos.crud.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // 얘는 나중에 설명 해주신다고 한다
public class UserBoard {
	private int id;
	private String title;
	private String content;
	private String userId;;
	private Timestamp createDate;
	private int readCount;
	private String username;
	private String email;
	private String searchContent;
	private String previewImg;
}
