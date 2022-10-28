package com.springboot.hello.controller;

import com.springboot.hello.domain.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/hello")
public class GetController {

    @GetMapping("")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping(value = "/name")
    public String getName() {
        return "hyeonju";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }



    @GetMapping(value = "/request1") //endpoint
    public String getVariable2(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String organization) {
        return String.format(" %s %s %s", name, email, organization);
    }

    // 예제 5.7
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
