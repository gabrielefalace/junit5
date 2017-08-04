package com.falace.extension.integration;

import org.junit.jupiter.api.extension.*;

public class IntegrationTestExtension implements TestInstancePostProcessor, BeforeTestExecutionCallback, AfterTestExecutionCallback, AfterAllCallback {

    private static final ExtensionContext.Namespace INTEGRATION_TEST_NAMESPACE = ExtensionContext.Namespace.create("com", "falace", "IntegrationTestExtension");

    // here the context refers to the Method
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        if (!isResourceClear(context))
            clearResource(context);
    }


    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (!isResourceClear(context))
            clearResource(context);
    }

    @Override
    public void afterAll(ExtensionContext context) {
        if (isResourceOpen(context))
            closeResource(context);
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        ExternalResourceTest test = (ExternalResourceTest) testInstance;
        Resource r = new Resource();
        r.open();
        test.setResource(r);
        context.getStore(INTEGRATION_TEST_NAMESPACE).put("testInstance", test);
    }


    // private helper methods

    private void clearResource(ExtensionContext context) {
        ExternalResourceTest t = (ExternalResourceTest) context.getStore(INTEGRATION_TEST_NAMESPACE).get("testInstance");
        if(t.getResource() != null)
            t.getResource().clear();
    }


    private void closeResource(ExtensionContext context) {
        ExternalResourceTest t = (ExternalResourceTest) context.getStore(INTEGRATION_TEST_NAMESPACE).get("testInstance");
        if(t.getResource() != null)
            t.getResource().close();
    }

    private boolean isResourceOpen(ExtensionContext context) {
        ExternalResourceTest t = (ExternalResourceTest) context.getStore(INTEGRATION_TEST_NAMESPACE).get("testInstance");
        return t.getResource() != null && t.getResource().isOpen();
    }

    private boolean isResourceClear(ExtensionContext context) {
        ExternalResourceTest t = (ExternalResourceTest) context.getStore(INTEGRATION_TEST_NAMESPACE).get("testInstance");
        return t.getResource() != null && t.getResource().isClear();
    }

}
