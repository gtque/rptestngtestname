package com.thegoate.rp.def;

import com.thegoate.Goate;
import com.thegoate.data.GoateDLP;
import com.thegoate.data.GoateProvider;
import com.thegoate.data.StaticDL;
import com.thegoate.rp.CustomTestNGListener;
import com.thegoate.testng.TestNGEngineMethodDL;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

//@Listeners({CustomTestNGListener.class})
public class SimpleITest extends TestNGEngineMethodDL {

    @GoateDLP(name = "simple data")
    public Goate[] dlp() {
        Goate[] d = new Goate[2];
        d[0] = new Goate()
                .put("dl##", new StaticDL().add("status", true).add("Scenario", "def first pass"))
                .put("dl##", new StaticDL().add("status", false).add("Scenario", "def second pass"))
                .put("dl##", new StaticDL().add("status", true).add("Scenario", "def third pass"));
        return d;
    }

    @GoateProvider(name = "simple data")
    @Test(groups = {"unit"}, dataProvider = "methodLoader")
    public void genericTestName(Goate testData) {
        assertTrue(testData.get("status", true, Boolean.class));
    }

    @GoateProvider(name = "simple data")
    @Test(groups = {"unit"}, dataProvider = "methodLoader")
    public void genericTestName2(Goate testData) {
        assertTrue(testData.get("status", true, Boolean.class));
    }

}
