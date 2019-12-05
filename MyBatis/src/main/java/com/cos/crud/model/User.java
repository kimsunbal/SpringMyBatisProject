package com.cos.crud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter
@AllArgsConstructor
@NoArgsConstructor
@Builder // 얘는 나중에 설명 해주신다고 한다
public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String userProfile;
}