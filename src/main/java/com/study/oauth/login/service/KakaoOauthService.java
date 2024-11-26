package com.study.oauth.login.service;

import com.study.oauth.login.external.KakaoApiClient;
import com.study.oauth.login.external.KakaoOauthClient;
import com.study.oauth.login.model.KakaoOauthToken;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KakaoOauthService {

  @Value("${kakao.oauth.client-id}")
  private String clientId;
  @Value("${kakao.oauth.redirect-uri}")
  private String redirectUri;

  private final KakaoOauthClient kakaoOauthClient;
  private final KakaoApiClient kakaoApiClient;

  public void kakaoLoginProcess(String authCode) {
    // 토큰 요청
    KakaoOauthToken kakaoToken = kakaoOauthClient.getKakaoToken(
        "authorization_code",
        clientId,
        redirectUri,
        authCode
    );

    // 사용자 정보 조회
    String authorization = "Bearer " + kakaoToken.getAccessToken();
    Map<String, Object> kakaoMemberInfo = kakaoApiClient.getKakaoMemberInfo(authorization);

    // 조회된 사용자 정보를 이용해서 로그인 혹은 회원가입을 진행한후 비즈니스 로직을 마무리한다.
    System.out.println(kakaoMemberInfo);
  }
}