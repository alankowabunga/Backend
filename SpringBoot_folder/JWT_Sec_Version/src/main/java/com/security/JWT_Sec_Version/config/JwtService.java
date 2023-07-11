package com.security.JWT_Sec_Version.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParserBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {

//    定義 JWT 密鑰( 256-bit ): 私人靜態不可變的字串型態常數
    private static final String SECRET_KEY = "uSfztxqAvg4IGQpNmY83YW4darMrnv6K";

    public void extractUsername(String token) {
        return null;
    }

//    取得單一 Claim

//    取得所有 Claims
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                // return JWT parser Builder
                .setSigningKey(getSignInKey())
                // 傳入 Key 來設置金鑰
                .build()
                // return JWT Object
                .parseClaimsJws(token)
                // return verfied JWS Object
                .getBody(); //
                // return Claims Oject，用於（payload）部分 Claims 的方法。
    }

//   取得 解析後的密鑰 Sign-In Key。
    private Key getSignInKey() {
        byte[] decodeBytes = Base64.getDecoder().decode(SECRET_KEY);
        SecretKey myKey = Keys.hmacShaKeyFor(decodeBytes);
        return myKey;
    }
}
