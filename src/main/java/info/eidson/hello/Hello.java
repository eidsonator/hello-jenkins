package info.eidson.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hello {
//    private static Logger logger = LoggerFa
    private static Logger logger = LoggerFactory.getLogger(Hello.class);

    public static void main(String[] args) {
        logger.info("Hello Jenkins");
        logger.info("Hello Jenkinsins");
//        System.out.println("Hello Jenkinskins");
    }

    public int what(int a) {
        return a * 2;
    }
}
