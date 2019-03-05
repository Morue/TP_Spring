package fr.iocean.dta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExempleLog {
	 
    private static final Logger logger 
      = LoggerFactory.getLogger(ExempleLog.class);
 
    public static void main(String[] args) {
        logger.info("Example log from {}", ExempleLog.class.getSimpleName());
    }
}
