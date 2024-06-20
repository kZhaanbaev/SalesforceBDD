package stepDefs;

import core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {
    private TestContext testContext;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp(){
        testContext.getDriver().get(ConfigReader.readProperty("config.properties", "url"));
    }

    @After
    public void tearDown(){
        testContext.getDriver().quit();
    }
}
