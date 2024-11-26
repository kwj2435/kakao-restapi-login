package com.study.oauth.login.controller;

import com.study.oauth.login.service.KakaoOauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/login")
@RequiredArgsConstructor
public class LoginController {

  private final KakaoOauthService kakaoOauthService;

  @GetMapping("/kakao/callback")
  public void kakaoCallback(@RequestParam("code") String code) {
    kakaoOauthService.kakaoLoginProcess(code);
  }
}