package web.springmvc.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author puck
 * @Description
 * @Date 2018/9/1
 */
@Controller
@RequestMapping
@Slf4j
public class ForC {

    @RequestMapping("/for")
    public String test(Model view, HttpServletRequest request){
        log.info("request in..{}，{}", request.getRemoteAddr(), request.getRemoteHost());
        System.out.println(("request in..{}，{}" + request.getRemoteAddr() + request.getRemoteHost()));
        return "canvas/roseh";
    }
}
