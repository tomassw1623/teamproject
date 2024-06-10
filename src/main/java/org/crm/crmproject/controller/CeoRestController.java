package org.crm.crmproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Ceo;
import org.crm.crmproject.dto.CeoDTO;
import org.crm.crmproject.repository.CeoRepository;
import org.crm.crmproject.security.CrmUserDetailsService;
import org.crm.crmproject.security.JwtProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/api/")
public class CeoRestController {

    private final JwtProvider jwtProvider;
    private final CeoRepository ceoRepository;
    private final PasswordEncoder passwordEncoder;
    private final CrmUserDetailsService crmUserDetailsService;

    @GetMapping("/ceo/update")
    public ResponseEntity<Optional<Ceo>> getCeoData(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            // Authorization 헤더에서 Access Token 추출
            String accessToken = extractAccessToken(authorizationHeader);

            // Access Token을 사용하여 사용자 인증하고 사용자 정보 가져오기
            Map<String, Object> claims = jwtProvider.validateToken(accessToken);
            String username = (String) claims.get("username");

            // CeoRepository에서 CEO 데이터 가져오기
            Optional<Ceo> ceo = ceoRepository.getWithRoles(username);

            // 클라이언트에게 CEO 데이터 반환
            return ResponseEntity.ok(ceo);
        } catch (Exception e) {
            log.error("Failed to process request: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @PutMapping("/ceo/update")
    public ResponseEntity<String> updateCeoData(@RequestBody CeoDTO ceoDTO) {
        ceoRepository.updateCeo(passwordEncoder.encode(ceoDTO.getCeoPw()), ceoDTO.getCeoName(), ceoDTO.getCeoEmail(),
                ceoDTO.getCeoPhone(), ceoDTO.getStoreAddress(), ceoDTO.getCeoId());

        return ResponseEntity.ok("Ceo data updated successfully!");
    }

    private String extractAccessToken(String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }

    @GetMapping("/ceo/main")
    public ResponseEntity<?> getCeoMain(@RequestHeader("Authorization") String authorizationHeader) {
        try {
            log.info("레 스 트 겟 C E O 메 인");
            // Authorization 헤더에서 Access Token 추출
            String accessToken = extractAccessToken(authorizationHeader);

            // Access Token을 사용하여 사용자 인증하고 사용자 정보 가져오기
            Map<String, Object> claims = jwtProvider.validateToken(accessToken);
            String username = (String) claims.get("username");

            // 현재 인증된 사용자 정보 가져오기
            UserDetails userDetails = crmUserDetailsService.loadUserByUsername(username);

            // Spring Security의 SecurityContextHolder에 사용자 정보 등록
            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // CeoRepository에서 CEO 데이터 가져오기
            Optional<Ceo> ceo = ceoRepository.getWithRoles(username);

            // 클라이언트에게 CEO 데이터 반환
            return ResponseEntity.ok(ceo);
        } catch (Exception e) {
            log.error("Failed to process request: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
