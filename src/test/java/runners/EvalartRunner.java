package runners;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import utils.BeforeSuite;
import utils.DataToFeature;



import java.io.IOException;

@RunWith(RunnerPersonalizado.class)
@CucumberOptions(
        features="src/test/resources/features/evalart_automation.feature",
        glue="stepdefinitions",
        plugin = {"pretty","json:target/cucumber-reports/cucumber.json"},
        snippets= CucumberOptions.SnippetType.CAMELCASE)

public class EvalartRunner {

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/evalart_automation.feature");
    }
    @BeforeClass
    public static void setup() {
        OnStage.setTheStage(new OnlineCast());
    }

}
