package com.menondemand.jwtauthentication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@FeignClient("user-service")
public interface UserClient {

}
