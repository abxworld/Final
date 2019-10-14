package com.bsworld.springboot.generic;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-23 15:41
 * description:
 */
public class NovelEndingBatchReq {
    List<NovelEndingReq> endingReqs;

    public List<NovelEndingReq> getEndingReqs() {
        return endingReqs;
    }

    public void setEndingReqs(List<NovelEndingReq> endingReqs) {
        this.endingReqs = endingReqs;
    }

    public static void main(String[] args) {
        NovelEndingBatchReq req = new NovelEndingBatchReq();
        NovelEndingReq endingReq = new NovelEndingReq();
        endingReq.setId(1000l);
        endingReq.setChapterId(1111l);
        endingReq.setCoverPic("1121212.png");
        endingReq.setCreateTime(new Date().getTime());
        endingReq.setName("hello");
        req.setEndingReqs(Lists.newArrayList(endingReq));
        System.out.println(JSON.toJSONString(req));
    }
}
