package tests;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.CSVDataReader;
import utils.TestNgListener;

public class ApplyToJob {

	@Listeners(TestNgListener.class)
	public class LoginTest extends BaseTest {

		@Test(priority = 1)
		public void applyToJob() throws InterruptedException {

			app.menu.acceptCookies.click();
			CSVDataReader credentials = new CSVDataReader();
			String user = credentials.getCredentials().get("Username");
			String password = credentials.getCredentials().get("Password");
			app.account.loginInApp(user, password);

			app.menu.search("QA Engineer");
			app.menu.jobPage.click();

			// filterByTimePostedRange

			app.job.filterByTimePostedRange(app.job.datePosted, app.job.pastMonth);
			app.job.showResults.click();
			
            //filterByExperienceLevel

			List<WebElement> experienceLevelList = new ArrayList<WebElement>();
			experienceLevelList.add(app.job.associate);
			experienceLevelList.add(app.job.midSenior);
			app.job.filterByExperienceLevel(app.job.experienceLevel, experienceLevelList);
			app.job.showResults.click();
		}
	}
}