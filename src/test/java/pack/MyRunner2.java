package pack;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/feature1.feature",glue="tests",
		plugin= {"pretty","html:target/myresults"},monochrome=true)
public class MyRunner2 
{
	

}
