package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController {

    @GetMapping("")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping(value = "/request1") //endpoint
    public String getVariable2(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String organization) {
        return String.format(" %s %s %s", name, email, organization);
    }

    @GetMapping (value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
//            sb.append(map.getKey() + " " + map.getValue() + "\n" );
            System.out.printf("key: %s value: %s", map.getKey(), map.getValue());
        });
        return "request2가 호출 완료되었습니다.";

    }

    @GetMapping (value = "/request3")
    public String getRequestParam(MemberDto memberDto) {
        return memberDto.toString();
    }


}
