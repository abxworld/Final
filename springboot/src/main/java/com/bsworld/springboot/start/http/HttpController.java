package com.bsworld.springboot.start.http;

import com.bsworld.springboot.start.util.FileUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-10-21 20:33
 * description:
 */
@RestController("/ht")
public class HttpController {


    @PostMapping(value = "/test1")
    public void run() {
        String remoteHost = FileUtil.getRemoteHost();
    }

}
