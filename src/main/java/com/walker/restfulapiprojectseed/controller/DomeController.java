package com.walker.restfulapiprojectseed.controller;

import com.walker.restfulapiprojectseed.pojo.Api1Req;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base_url/")
public class DomeController {

    /**
     * @param req
     * @param name
     */
    @PostMapping(value = "test_api")
    public void api1(@RequestBody Api1Req req, @RequestHeader("head_name") Object name) {

    }

    /**
     * @param param
     */
    @GetMapping(value = "test_api2")
    public void api2(@RequestParam(value = "getParam", required = false) Object param) {

    }


}
