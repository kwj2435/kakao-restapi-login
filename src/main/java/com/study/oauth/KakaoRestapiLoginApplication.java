package com.study.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class KakaoRestapiLoginApplication {

  public static void main(String[] args) {
    SpringApplication.run(KakaoRestapiLoginApplication.class, args);
  }

}
