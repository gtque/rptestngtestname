package com.thegoate.rp.custom;

import com.thegoate.Goate;
import com.thegoate.rp.CustomTestNGListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Listeners({CustomTestNGListener.class})
@Test(testName = "Test Name Set for the class, only makes sense if only one test method, but whatever.")
public class SimpleTestClassAnnotation {

    @DataProvider(name = "class data")
    public Object[][] simpleData() {
        Object[][] runs = new Object[3][1];
        runs[0][0] = new Goate().put("status", true).put("Scenario", "first pass");
        runs[1][0] = new Goate().put("status", false).put("Scenario", "second fail");
        runs[2][0] = new Goate().put("status", true).put("Scenario", "third pass");
        return runs;
    }

    @Test(groups = {"unit"}, dataProvider = "class data")
    public void genericTestName(Goate testData) {
        assertTrue(testData.get("status", true, Boolean.class));
    }

}
