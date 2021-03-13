import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import com.viskan.log4j.logstash.appender.LogstashAppender
import net.logstash.logback.appender.LogstashTcpSocketAppender
import net.logstash.logback.encoder.LoggingEventCompositeJsonEncoder
import net.logstash.logback.encoder.LogstashEncoder;

import static ch.qos.logback.classic.Level.*

//def MSG_PATTERN = "=%d{ISO8601} %highlight(%5p) [%thread]"
//
scan("60 seconds") // scan for changes every minute
//appender("stdout", ConsoleAppender) {
//    target = "System.out"
//    encoder(PatternLayoutEncoder) {
//        pattern = "${MSG_PATTERN}"
//    }
//}

def LOG_PATH="logs"

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    target = "System.out"
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}

appender("File-Appender", FileAppender) {
    file = "${LOG_PATH}/logfile.log"
    encoder(PatternLayoutEncoder) {
        pattern = "%msg%n"
        outputPatternAsHeader = true
    }
}

//appender("logstash", LogstashAppender){
//    encoder(PatternLayoutEncoder) {
//        pattern = "%level %logger - %msg%n"
//    }
//}

appender("STASH", LogstashTcpSocketAppender) {
    println "Setting [destination] property to 127.0.0.1:5000"
//    destination =  "127.0.0.1:5000"
    remoteHost = "127.0.0.1"
    port = 5000
//    encoder(LoggingEventCompositeJsonEncoder) {
//        pattern = "%msg%n"
//    }
    encoder(LogstashEncoder) {
//        customFields = """{ "token": "xxxxx", "environment":"dev", "some_property":"foobar" }"""
        pattern = "%msg%n"
    }

}

logger("info.eidson.hello", ALL, ["STDOUT", "STASH"])
root(ALL, ["File-Appender"])


//appender('LOGSTASH', LogstashTcpSocketAppender) {
//
//}