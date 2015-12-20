package usr.sample;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Created by Администратор on 15.12.2015.
 */
public class TaskTest {

    private Logger logger = Logger.getLogger(TaskTest.class);

    //@Value( "${abc}" )
    String str;

    public void runTask() {
        System.out.print("ss1");
        logger.info("tick job = " + str);
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
