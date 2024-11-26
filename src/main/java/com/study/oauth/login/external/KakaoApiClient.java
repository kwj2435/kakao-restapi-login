package com.study.oauth.login.external;

import feign.Headers;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "KakaoApiClient", url = "https://kapi.kakao.com/v2")
public interface KakaoApiClient {

  @GetMapping("/user/me")
  @Headers("Content-Type: application/x-www-form-urlencoded;charset=utf-8")
  Map<String, Object> getKakaoMemberInfo(@RequestHeader("Authorization") String token);
}
