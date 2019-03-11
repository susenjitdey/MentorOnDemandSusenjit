package com.menondemand.jwtauthentication.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.menondemand.jwtauthentication.message.request.BlockUserReq;

@CrossOrigin(origins = "*", maxAge = 3600)
@FeignClient("userAccessService")
public interface UserClient {
	
	@PostMapping("/user/block")
	ResponseEntity<?> blockUser(@RequestBody BlockUserReq blockUserRequest);
	
	@PostMapping("/user/unblock")
	ResponseEntity<?> unblockUser(@RequestBody BlockUserReq blockUserRequest);

}
