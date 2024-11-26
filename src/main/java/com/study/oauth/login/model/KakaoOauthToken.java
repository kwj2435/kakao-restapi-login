package com.study.oauth.login.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaoOauthToken {
  private String tokenType;

  private String accessToken;

  private String idToken;

  private Integer expiresIn;

  private String refreshToken;

  private Integer refreshTokenExpiresIn;

  private String scope;
}
