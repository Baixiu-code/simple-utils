package com.craftsman.sample.foundation.groovy;


import java.io.FileInputStream;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.apache.commons.io.IOUtils;

/**
 * @author craftsman
 * @date 2019年09月26日
 */
public class JavaParseGroovy {

    private static String GROOVY_FILE = "/Users/chenfanglin/Desktop/private/code/simple-util/simple-utils/src/main/" +
            "java/com/craftsman/sample/foundation/groovy/HelloWord.groovy";

    public static void main(String[] args) throws ScriptException, IOException {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("groovy");
        String scriptContent = IOUtils.toString(new FileInputStream(GROOVY_FILE));
        engine.eval(scriptContent);
    }

}