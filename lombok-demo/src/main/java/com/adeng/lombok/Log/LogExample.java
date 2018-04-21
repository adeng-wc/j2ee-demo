package com.adeng.lombok.Log;


import lombok.extern.java.Log;

/**
 * @author
 *
 * @CommonsLog
 * 创建 private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LogExample.class);
 * @JBossLog
 * 创建 private static final org.jboss.logging.Logger log = org.jboss.logging.Logger.getLogger(LogExample.class);
 * @Log
 * 创建 private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
 * @Log4j
 * 创建 private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LogExample.class);
 * @Log4j2
 * 创建 private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);
 * @Slf4j
 * 创建 private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
 * @XSlf4j
 * 创建 private static final org.slf4j.ext.XLogger log = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);
 *
 * @create 2018-04-21 23:41
 */
@Log
public class LogExample {

    public static void main(String... args) {
        log.info("Something's wrong here");
    }
}
