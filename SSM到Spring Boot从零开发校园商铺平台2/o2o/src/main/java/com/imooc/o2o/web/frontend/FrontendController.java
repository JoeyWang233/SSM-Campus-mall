package com.imooc.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: o2o
 * @description:
 * @author: Joey
 * @create: 2019-04-16 14:18
 */
@Controller
@RequestMapping(value = "/frontend")
public class FrontendController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    private String index(){
        return "frontend/index";
    }

    /**
     * 商店列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/shoplist",method = RequestMethod.GET)
    private String shoplist(){
        return "frontend/shoplist";
    }
}
