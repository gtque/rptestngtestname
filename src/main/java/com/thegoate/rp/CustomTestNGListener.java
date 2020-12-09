package com.thegoate.rp;

import com.epam.reportportal.testng.BaseTestNGListener;
import com.epam.reportportal.testng.ITestNGService;
import rp.com.google.common.base.Supplier;
import rp.com.google.common.base.Suppliers;

public class CustomTestNGListener extends BaseTestNGListener {

    static final ReportPortalTestNGService service = new ReportPortalTestNGService();
    /* static instance with lazy init */
    public static final Supplier<ITestNGService> SERVICE = Suppliers.memoize(new Supplier<ITestNGService>() {
        @Override
        public ITestNGService get() {
            return service;
        }
    });

    public CustomTestNGListener() {
        super(SERVICE.get());
    }
}
