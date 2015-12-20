package usr.sample;

import usr.sample.ws.SampleService;

/**
 * Created by Администратор on 20.12.2015.
 */
public class SampleServiceImpl implements SampleService {

    public String getStr1(String yourName) {
        return "Hel " + yourName + "!!!";
    }
}
