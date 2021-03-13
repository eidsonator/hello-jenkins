package info.eidson.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Hello {
//    private static Logger logger = LoggerFa
    private static final Logger logger = LoggerFactory.getLogger(Hello.class);

    public static void main(String[] args) {
        logger.info("Hello Jenkins");
        logger.info("Hello Jenkinsins");
        
        List list = new ArrayList();
        Stream s = list.stream();
    }

    public int what(int a) {
        return a * 2;
    }
}
