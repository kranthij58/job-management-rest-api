package com.kranthi.JobApp2.service;

import com.kranthi.JobApp2.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    final private String secret;

    public JwtService(){
        secret = generateSecretKey();
    }

    public String generateSecretKey(){
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGenerator.generateKey();
            System.out.println("The secret key" + secretKey);
            return Encoders.BASE64.encode(secretKey.getEncoded());
        }catch (NoSuchAlgorithmException e){
            System.out.println("Key not generated " + e);
            throw new RuntimeException(e);
        }
    }


    public String generateToken(User user) {
        Map<String,Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims(claims)
                .subject(user.getUsername())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 600))
                .issuedAt(new Date(System.currentTimeMillis()))
                .signWith(getKey())
                .compact();
    }


    public Key getKey(){
        byte[] keys = Decoders.BASE64.decode(secret);
        return Keys.hmacShaKeyFor(keys);
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims,T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return (extractUserName(token).equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return expirationDate(token).before(new Date());
    }

    private Date expirationDate(String token) {
        return extractClaim(token,Claims::getExpiration);
    }
}
