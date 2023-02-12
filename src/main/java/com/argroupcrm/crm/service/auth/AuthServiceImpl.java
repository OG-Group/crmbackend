package com.argroupcrm.crm.service.auth;

import com.argroupcrm.crm.dto.auth.LoginDTO;
import com.argroupcrm.crm.security.jwt.JwtProvider;
import com.argroupcrm.crm.security.jwt.JwtResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public ResponseEntity<JwtResponse> signIn(LoginDTO loginDTO) {
        try {
            String trimmedLoginInLowerCase = loginDTO.getLogin().trim();
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    trimmedLoginInLowerCase,
                    loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info(authToken.getAuthorities().toString());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwtToken = jwtProvider.jwtGenerate(authentication);
            log.info(jwtToken);
            String login = jwtProvider.getLoginFromToken(jwtToken);
            return ResponseEntity.ok(new JwtResponse(jwtToken, login));
        } catch (InternalAuthenticationServiceException e) {
            log.info("InternalAuthenticationServiceException| user dont exist?");
            return ResponseEntity.status(400).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }
}