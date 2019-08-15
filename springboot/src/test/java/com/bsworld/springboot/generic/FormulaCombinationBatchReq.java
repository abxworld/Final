package com.bsworld.springboot.generic;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * program: Final
 * author: bsworld.xie
 * create: 2019-07-23 17:08
 * description:
 */
public class FormulaCombinationBatchReq {
    private List<FormulaCombinationReq> formulaCombinationReqs;

    public List<FormulaCombinationReq> getFormulaCombinationReqs() {
        return formulaCombinationReqs;
    }

    public void setFormulaCombinationReqs(List<FormulaCombinationReq> formulaCombinationReqs) {
        this.formulaCombinationReqs = formulaCombinationReqs;
    }

    public static void main(String[] args) {
        FormulaCombinationBatchReq req = new FormulaCombinationBatchReq();
        FormulaCombinationReq combinationReq = new FormulaCombinationReq();
        FormulaCombinationReq combinationReq1 = new FormulaCombinationReq();
        combinationReq.setNovelId(2469906132995l);
        combinationReq.setBackPic("23063069204501543996011866.png");
        combinationReq.setType(1);
        combinationReq.setVariableIds("1294940413366370307,1295255139979886595");
        combinationReq1.setNovelId(2469906132995l);
        combinationReq1.setBackPic("23063069204501543996011866.png");
        combinationReq1.setType(2);
        combinationReq1.setVariableIds("1294940413366370307,1295255139979886595");
        req.setFormulaCombinationReqs(Lists.newArrayList(combinationReq,combinationReq1));
        System.out.println(JSON.toJSONString(req));
    }
}
