package com.prac.jwt;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	private String SECRET ="mySecretKey";
	
	public String getTypeFromToken(String token) {
        Claims claims =  getAllClaimsFromToken(token);
        return claims.get("type").toString();
    }
	
	private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }
	
	public String getJwtForAdmin(String admin_id) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_Admin");
		Claims claim = Jwts.claims();
		claim.put("type", "Admin");
		claim.put("authorities", grantedAuthorities.stream()	.map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
		
		String token = Jwts
				.builder()
				.setSubject(admin_id)
				.setClaims(claim)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,	SECRET.getBytes())
				.compact();
		
		return token;
	}
	
	public String getJwtForUser(String user_id) {
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_user");
		Claims claim = Jwts.claims();
		claim.put("type", "User");
		claim.put("authorities", grantedAuthorities.stream()	.map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
		
		String token = Jwts
				.builder()
				.setSubject(user_id)
				.setClaims(claim)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,	SECRET.getBytes())
				.compact();
		
		return token;
	}
	
	

}
