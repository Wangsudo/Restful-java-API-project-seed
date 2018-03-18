package com.walker.restfulapiprojectseed.controller;

import com.walker.restfulapiprojectseed.pojo.Api1Req;
import com.walker.restfulapiprojectseed.pojo.UserVo;
import com.walker.restfulapiprojectseed.utils.R;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base_url/")
public class DomeController {

    /**
     * @param req
     * @param name
     */
    @PostMapping(value = "test_api")
    public R api1(@RequestBody Api1Req req, @RequestHeader("head_name") Object name) {
        return R.SUCCESS;
    }

    /**
     * @param param
     */
    @GetMapping(value = "test_api2")
    public void api2(@RequestParam(value = "getParam", required = false) Object param) {

    }

    /**
     * 测试无参的get请求
     * @return
     */
    @GetMapping(value = "testAspect")
    public R test(){
        UserVo userVo = new UserVo();
        userVo.setId(1);
        userVo.setName("walker");
        userVo.setSex("man");
        return new R(userVo);
    }


    /**
     * 测有参的get请求
     * @param id
     * @param name
     * @param sex
     * @return
     */
    @GetMapping(value = "testAspectArgs")
    public R test(@RequestParam("id")Integer id,@RequestParam("name")String name,@RequestParam("sex")String sex){
        UserVo userVo = new UserVo();
        userVo.setId(id);
        userVo.setName(name);
        userVo.setSex(sex);
        return new R(userVo);
    }

    /**
     * 测试带有参数的post请求
     * @param userVo
     * @return
     */
    @PostMapping(value = "testAspectArgs")
    public R test(@RequestBody UserVo userVo){
        userVo.setName(userVo.getName()+"shun");
        return new R(userVo);
    }



}
