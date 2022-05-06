package stepDefinitions;

import commons.BrowserManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BrowserManager {

    @Before
    public void setUp() {
        launchBrowser("Chrome");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
