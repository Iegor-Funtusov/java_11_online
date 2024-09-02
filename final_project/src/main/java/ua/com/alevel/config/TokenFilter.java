package ua.com.alevel.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.com.alevel.persistence.entity.user.Token;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.TokenRepository;

import java.io.IOException;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TokenFilter extends OncePerRequestFilter {

    private static final String AUTH_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "bearer";

    private final TokenRepository tokenRepository;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader(AUTH_HEADER);
        if (StringUtils.isBlank(authHeader) || !authHeader.startsWith(BEARER_PREFIX)) {
            filterChain.doFilter(request, response);
            return;
        }

        final String tokenValue = authHeader.substring(BEARER_PREFIX.length());
        final Optional<Token> optionalToken = tokenRepository.findByToken(tokenValue);
        if (optionalToken.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }
        final Token token = optionalToken.get();
        final User user = token.getUser();
        final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        if (userDetails != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            final SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
            final var authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());
            securityContext.setAuthentication(authentication);
            SecurityContextHolder.setContext(securityContext);
        }
        filterChain.doFilter(request, response);
    }
}
