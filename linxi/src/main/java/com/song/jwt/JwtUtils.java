package com.song.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;

/**
 * @author songfeng
 * @date 2020/09/22
 */
public class JwtUtils {
  private final String secretString = "12345678901234567890123456789012";
  private final SecretKey key = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
  public String generateToken(String userId, String userNick, Map<String, Object> other) {
    // 设置有效时间
    long period = 7200000;
    JwtBuilder jwtBuilder = Jwts.builder()
        // 使用setClaims可以将Map数据进行加密，必须放在其他变量之前
        .setClaims(other)
        .setId(userId)
        .setSubject(userNick)
        // 设置有效期
        .setExpiration(new Date(System.currentTimeMillis() + period))
        .signWith(key);
    return jwtBuilder.compact();
  }
  public Claims parseToken(String token){
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
  }
}