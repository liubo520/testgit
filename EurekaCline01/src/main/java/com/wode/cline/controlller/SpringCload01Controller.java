package com.wode.cline.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 85444 on 2018/5/6.
 */
@Controller
public class SpringCload01Controller {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("test")
    @ResponseBody
    public Object test(){
        return restTemplate.getForEntity("http://cloud-client-02/test",String.class);
    }
}
