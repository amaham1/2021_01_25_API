package com.prac.jwt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public String passWordCreate(String passWord) {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		String encodePassWord = bCryptPasswordEncoder.encode(passWord);
		return encodePassWord;
	}
	
	public boolean comparePassWord(String firstPassWord, String secondPassWord) {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
		boolean result = bCryptPasswordEncoder.matches(firstPassWord, secondPassWord);
		return result;
	}

}
