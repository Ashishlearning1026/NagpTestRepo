import baseClass.BaseClass;
import org.testng.annotations.Test;

public class TestCase1 extends BaseClass {
    @Test
    public void Testcase1(){
        System.out.println("This is Test Case 1");
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }

    @Test
    public void Testcase2(){
        System.out.println("This is Test Case 2");
        softAssert.assertTrue(true);
        softAssert.assertAll();
    }
}
