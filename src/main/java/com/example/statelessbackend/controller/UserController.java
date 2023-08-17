package com.example.statelessbackend.controller;

import com.example.statelessbackend.common.BaseResponse;
import com.example.statelessbackend.common.ResultUtils;
import com.example.statelessbackend.exception.BusinessException;
import com.example.statelessbackend.request.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import static com.example.statelessbackend.common.ErrorCode.NULL_ERROR;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @GetMapping("/hello")
    public BaseResponse<String> hello() {
        return ResultUtils.success("hello");
    }

    @PostMapping("/welcome")
    public BaseResponse<String> welcome(@RequestBody UserRequest user){
        if (StringUtils.isAnyBlank(user.getUsername()))
            throw new BusinessException(NULL_ERROR);
        log.info("UserController welcome: " + user.getUsername());
        return ResultUtils.success("welcome " + user.getUsername());
    }

}
