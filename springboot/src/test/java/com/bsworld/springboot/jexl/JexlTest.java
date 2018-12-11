package com.bsworld.springboot.jexl;
/*
*author: xieziyang
*date: 2018/8/6
*time: 9:35
*description:
*/

import com.alibaba.fastjson.JSON;
import com.bsworld.springboot.validate.JexlUtil;
import org.apache.commons.jexl3.*;
import org.apache.commons.jexl3.internal.Engine;
import org.junit.Test;

public class JexlTest {
    @Test
    public void run1() {
        String expression = "while(10 > 5){ a = 8;break;}";

        JexlExpression e = new JexlBuilder().create().createExpression(expression);
        JexlContext context = new MapContext();
        context.set("a", 0);
        Object evaluate = e.evaluate(context);
        System.out.println(JSON.toJSONString(evaluate));
    }

    @Test
    public void run2() {
        JexlContext jc = new MapContext();
        jc.set("a", 1);
        jc.set("b", "0");
        jc.set("ans", new StringBuffer());
        JexlExpression e = new Engine().createExpression("while (a < 10) {a = a + 1;ans.append(b);}");
        e.evaluate(jc);
        System.out.println(jc.get("ans"));
    }

    @Test
    public void run3() {
        JexlEngine engine = new JexlBuilder().create();
        String expression = " if (10 > 5) {\n" +
                "            a = 8;\n" +
                "        }";
        JexlExpression e = engine.createExpression(expression);
        JexlContext context = new MapContext();
        context.set("a", 10);
        Object evaluate = e.evaluate(context);
        System.out.println(evaluate);
    }

    @Test
    public void run4() {
        String expression = " if (10 > 5) {\n" +
                "            a = 8;\n" +
                "        }";
        JexlContext context = new MapContext();
        context.set("a", 10);
        JexlUtil.execute(expression, context);
        System.out.println("start");
        JexlUtil.execute(expression, context);
    }

    @Test
    public void run5() {
        Long a  =10l;
        Long b = new Long(10l);
        Long c = 10l;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(null));
    }


}
