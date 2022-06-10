//package com.example.demo.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.util.StringUtils;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//import java.io.IOException;
//
////Extend OncePerRequestFilter to ensure process each dispatched request only once
////Extend OncePerRequestFilter to ensure process each dispatched request only once
////JwtAuthenticationFilter validates the Token using JwtTokenProvider:
//public  class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    // inject dependencies
//    @Autowired
//    private JwtTokenProvider tokenProvider;
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        // get JWT (token) from http request
//        String token = getJWTfromRequest(request);
//        // validate token
//        if (StringUtils.hasText(token) && tokenProvider.validateToken(token)) {
//            // get username from token
//            String username = tokenProvider.getUsernameFromJWT(token);
//            // load user associated with token
//            UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//
//            // create AuthenticationToken
//            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
//                    userDetails, null, userDetails.getAuthorities()
//            );
//
//            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//            // set spring security, Store Authentication object in SecurityContext
//            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    // Bearer <accessToken>
//    private String getJWTfromRequest(HttpServletRequest request) {
//        String bearerToken = request.getHeader("Authorization");
//        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
//    }
//
//}