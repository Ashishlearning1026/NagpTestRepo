package baseClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.asserts.SoftAssert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseClass {

    protected static SoftAssert softAssert;
    protected static ExtentReports extent = new ExtentReports();
    protected static ExtentSparkReporter spark = new ExtentSparkReporter("testoutput/ExtentReport.html");
    protected static ExtentTest test;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite()
    {
        softAssert = new SoftAssert();
        spark.config().setDocumentTitle("My Report For Jenkins");
        extent.attachReporter(spark);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
        test=extent.createTest(getClass().getName()+":-"+method.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS,"Status is Passed");
        }else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,"Status is Failed");
        }else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP,"Status is Skipped");
        }else{
            test.log(Status.WARNING,"Status is Unknown");
        }
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        extent.flush();
    }
}
