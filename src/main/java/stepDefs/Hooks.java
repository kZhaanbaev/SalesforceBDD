package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {

    @Before
    public void setUp(){
        //set up related code goes here
    }

    @After
    public void tearDown(){
        Driver.getDriver().quit();
    }
}
