package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.persistence.entity.user.Token;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.TokenRepository;
import ua.com.alevel.service.AuthService;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final TokenRepository tokenRepository;

    @Value("${token.expires_in}")
    private long expiresIn;

    public AuthServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token login(User user) {
        Optional<Token> optionalToken = tokenRepository.findByUser(user);
        if (optionalToken.isPresent()) {
            Token token = optionalToken.get();
            Date expiryDate = token.getExpiryDate();
            if (expiryDate.before(new Date())) {
                return token;
            }
            tokenRepository.deleteById(token.getId());
        }
        Token token = new Token();
        token.setUser(user);
        Date expiryDate = new Date(System.currentTimeMillis() + expiresIn);
        token.setExpiryDate(expiryDate);
        token.setToken(UUID.randomUUID().toString());
        tokenRepository.save(token);
        return token;
    }
}
