package com.thegoate.rp;

import com.epam.reportportal.testng.TestNGService;
import com.thegoate.logging.BleatBox;
import com.thegoate.logging.BleatFactory;
import org.testng.ITestResult;

public class ReportPortalTestNGService extends TestNGService {
    BleatBox LOG = BleatFactory.getLogger(getClass());

    @Override
    protected String createStepName(ITestResult testResult) {
        String name = super.createStepName(testResult);
        if(testResult.getTestClass().getRealClass().getPackage().toString().contains("custom")) {
            name = testResult.getName();
            LOG.info("using getTestName() for step name: " + name);
            if(name == null){
                LOG.info("name was null for: " + testResult.getTestName() + " (" + testResult.getTestClass().getRealClass().getName() + ")");
            } else {
                LOG.info("is getName() the same as getTestName(): " + name + " == " + testResult.getTestName());
                if(testResult.getTestName()!=null && !name.equals(testResult.getTestName())){
                    LOG.warn("getName("+name+") was not the same as getTestName("+testResult.getTestName()+")");
                } else {
                    if(testResult.getTestName()==null){
                        LOG.info("getTestName() returned null, so I should be using the method name instead...");
                        if(name.equals(testResult.getMethod().getMethodName())){
                            LOG.info("had to check method name, but getName("+name+") was equal to the method name.");
                        } else {
                            LOG.info("had to check method name, but getName("+name+") was NOT equal to the method name.");
                        }
                    } else {
                        LOG.info("getName and getTestName returned the same thing.");
                    }
                }
            }
        } else {
            LOG.info("using default implementation for step name.");
        }
        return name;
    }
}
