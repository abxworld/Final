package com.bsworld.springboot.javassit;
/*
*author: xieziyang
*date: 2018/9/17
*time: 14:39
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.validate.TestReq;
import com.bsworld.springboot.validate.WithdrawalReq;
import org.apache.ibatis.javassist.CannotCompileException;
import org.apache.ibatis.javassist.NotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavassitTest {
    public static void main(String[] args) throws IOException, CannotCompileException, NotFoundException {
     /*   ClassPool aDefault = ClassPool.getDefault();
        CtClass ctClass = aDefault.makeClass("com.bsworld.springboot.start.JavaYeTest");
        ctClass.writeFile();*/
        TestReq req = new TestReq();
        req.setAuditStatus((short)0);
        req.setAuditRemark("this is remark");
        WithdrawalReq message = new WithdrawalReq();
        WithdrawalReq message1 = new WithdrawalReq();
        message.setId(10l);
        message1.setId(10l);
        message.setWithFlowNo("0131463533");
        message1.setWithFlowNo("0131463533");
        message.setTransferTranSeq("4416856485");
        message1.setTransferTranSeq("4416856485");
        List<WithdrawalReq> list = new ArrayList<>();
        list.add(message);
        list.add(message1);
        req.setListArr(list);
        System.out.println(JSON.toJSONString(req));
    }
}
