package com.study.oauth.login.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginViewController {

  @Value("${kakao.oauth.client-id}")
  private String clientId;

  @Value("${kakao.oauth.redirect-uri}")
  private String redirectUri;

  /**
   * 카카오 로그인
   * @return
   */
  @GetMapping("/kakao")
  public String loginKakao(Model model) {
    String kakaoAuthDomain = "https://kauth.kakao.com/oauth/authorize";
    String responseType = "code";

    String kakaoLoginUrl = kakaoAuthDomain + "?" +
        "response_type=" + responseType +
        "&client_id=" + clientId +
        "&redirect_uri=" + redirectUri;

    model.addAttribute("kakaoLoginUri", kakaoLoginUrl);

    return "kakaoLogin";
  }
}