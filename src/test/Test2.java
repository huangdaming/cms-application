import org.apache.log4j.Logger;
import org.junit.Test;

public class Test2 {

    private static Logger log = Logger.getLogger(Test.class.getClass());
    @Test
    public void testLog(){
        log.debug("debug");
        log.error("error");
    }
    }