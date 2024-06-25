package com.dailycodebuffer.cloud.gateway.filter;

import config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.function.Predicate;

@RefreshScope
@Component
public class JwtAuthenticationFilter implements GatewayFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		try {
			ServerHttpRequest request = exchange.getRequest();

			final List<String> apiEndpoints = List.of("/register", "/login");

			Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
					.noneMatch(uri -> r.getURI().getPath().contains(uri));


			if (isApiSecured.test(request)) {
				if (!request.getHeaders().containsKey("Authorization")) {
					ServerHttpResponse response = exchange.getResponse();
					response.setStatusCode(HttpStatus.UNAUTHORIZED);

					return response.setComplete();
				}

				final String token = request.getHeaders().getOrEmpty("Authorization").get(0);

				if (JwtTokenProvider.validateToken(getJwtFromRequest(token)) == false) {
					ServerHttpResponse response = exchange.getResponse();
					response.setStatusCode(HttpStatus.BAD_REQUEST);
					return response.setComplete();
				}

//				try {
//					jwtUtil.validateToken(token);
//				} catch (JwtTokenMalformedException | JwtTokenMissingException e) {
//					e.printStackTrace();
//					ServerHttpResponse response = exchange.getResponse();
//					response.setStatusCode(HttpStatus.BAD_REQUEST);
//					return response.setComplete();
//				}

//				Claims claims = jwtUtil.getClaims(token);
//				exchange.getRequest().mutate().header("id", String.valueOf(claims.get("id"))).build();
			}

		}catch (Exception e){
			e.printStackTrace();
		}
		return chain.filter(exchange);
	}

	private String getJwtFromRequest(String bearerToken) {
		// Kiểm tra xem header Authorization có chứa thông tin jwt không
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

}
