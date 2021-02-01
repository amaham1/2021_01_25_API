package com.prac.jwt;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String SECRET = "mySecretKey";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		try {
			if (checkJWToken(request)) {
				Claims claims = validateToken(request);
				if (claims.get("authorities") != null) {
					setAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			}else {
				SecurityContextHolder.clearContext();
			}
			chain.doFilter(request, response);
		} catch (ExpiredJwtException e ) {
			logger.info("Expired Token");
		} catch (UnsupportedJwtException | MalformedJwtException e) {
			logger.info(e.getMessage());
		}
	}	
	
	//토큰 존재 확인
	private boolean checkJWToken(HttpServletRequest request) {
		String authenticationHeader = request.getHeader(HEADER);
		if (authenticationHeader == null)
			return false;
		return true;
	}
	
	//존재하는 경우 해독 및 유효성을 검사
	private Claims validateToken(HttpServletRequest request) throws ExpiredJwtException {
		String getHeader = request.getHeader(HEADER);
		return getAllClaimsFromToken(getHeader);
	}
	
	 private Claims getAllClaimsFromToken(String token) throws ExpiredJwtException{
	        return Jwts.parser()
	                .setSigningKey(SECRET.getBytes())
	                .parseClaimsJws(token)
	                .getBody();
	    }
	 
	private void setAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List<String>) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);

	}


}
