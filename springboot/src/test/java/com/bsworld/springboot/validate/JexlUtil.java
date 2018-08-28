package com.bsworld.springboot.validate;
/*
*author: xieziyang
*date: 2018/8/7
*time: 14:01
*description:
*/

import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlContext;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlScript;

public class JexlUtil {
    private static JexlEngine engine;

    private JexlUtil() {

    }

    private static JexlEngine getJexlEngine() {
        if (engine == null) {
            synchronized (JexlUtil.class) {
                if (engine == null) {
                    engine = new JexlBuilder().cache(10).create();
                }
            }
        }
        return engine;
    }

    public static Object execute(String expression, JexlContext context) {
        JexlEngine engine = getJexlEngine();
        JexlScript script = engine.createScript(expression);
        return script.execute(context);
    }
}
