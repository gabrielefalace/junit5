package com.falace.extension.integration;

import org.junit.jupiter.api.extension.*;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class IntegrationTestExtension implements TestInstancePostProcessor, BeforeTestExecutionCallback, AfterTestExecutionCallback, AfterAllCallback {

    private static final ExtensionContext.Namespace INTEGRATION_TEST_NAMESPACE = ExtensionContext.Namespace.create("com", "falace", "IntegrationTestExtension");
    public static final String RESOURCE = "resource";

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
        Resource resource = new Resource();
        resource.open();

        Field[] declaredFields = testInstance.getClass().getDeclaredFields();
        Field res = Stream.of(declaredFields)
                .filter(field -> field.isAnnotationPresent(ExternalResource.class))
                .collect(toList())
                .get(0);

        res.setAccessible(true);
        res.set(testInstance, resource);
        context.getStore(INTEGRATION_TEST_NAMESPACE).put(RESOURCE, resource);
    }


    // private helper methods

    private void clearResource(ExtensionContext context) {
        Resource resource = (Resource) context.getStore(INTEGRATION_TEST_NAMESPACE).get(RESOURCE);
        resource.clear();
    }

    private void closeResource(ExtensionContext context) {
        Resource resource = (Resource) context.getStore(INTEGRATION_TEST_NAMESPACE).get(RESOURCE);
        resource.close();
    }

    private boolean isResourceOpen(ExtensionContext context) {
        Resource resource = (Resource) context.getStore(INTEGRATION_TEST_NAMESPACE).get(RESOURCE);
        return resource.isOpen();
    }

    private boolean isResourceClear(ExtensionContext context) {
        Resource resource = (Resource) context.getStore(INTEGRATION_TEST_NAMESPACE).get(RESOURCE);
        return resource.isClear();
    }

}
