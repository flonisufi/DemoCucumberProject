package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    public Hooks()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @Before
    public void setUp()
    {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @AfterAll
    public static void after_all()
    {
        Driver.getDriver().quit();
    }

    @AfterStep
    public void Screenshot(Scenario scenario) throws IOException
    {
        if (scenario.isFailed())
        {
            File sourcPath = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcPath);
            scenario.attach(fileContent, "image/png", "Image");
        }

    }

}
