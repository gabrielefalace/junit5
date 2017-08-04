package com.falace.extension.benchmark;

import org.junit.jupiter.api.extension.*;

import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;
import static org.junit.platform.commons.util.AnnotationUtils.isAnnotated;


public class BenchmarkExtension implements BeforeAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback, AfterAllCallback {

    private static final ExtensionContext.Namespace BENCHMARK_NAMESPACE = ExtensionContext.Namespace.create("com", "falace", "BenchmarkExtension");

    // here the context refers to the Class
    @Override
    public void beforeAll(ExtensionContext context) {
        if (!isAnnotatedForBenchmark(context))
            return;
        saveNowAsStartTime(context, StartTimeKey.WHOLE_TEST_CLASS);
    }

    // here the context refers to the Method
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        if (!isAnnotatedForBenchmark(context))
            return;
        saveNowAsStartTime(context, StartTimeKey.SINGLE_TEST);
    }

    // here the context refers to the Method
    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (!isAnnotatedForBenchmark(context))
            return;
        long startTime = loadStartTime(context, StartTimeKey.SINGLE_TEST);
        long duration = currentTimeMillis() - startTime;
        report("Test", context, duration);
    }

    // here the context refers to the Class
    @Override
    public void afterAll(ExtensionContext context){
        if(!isAnnotatedForBenchmark(context))
            return;
        long startTime = loadStartTime(context, StartTimeKey.WHOLE_TEST_CLASS);
        long duration = currentTimeMillis() - startTime;
        report("Test container", context, duration);
    }

    // private helper methods

    private boolean isAnnotatedForBenchmark(ExtensionContext context) {
        return context.getElement().map(element -> isAnnotated(element, Benchmark.class)).orElse(false);
    }

    private long loadStartTime(ExtensionContext context, StartTimeKey startTimeKey) {
        return context.getStore(BENCHMARK_NAMESPACE).get(startTimeKey, long.class);
    }

    private void saveNowAsStartTime(ExtensionContext context, StartTimeKey startTimeKey) {
        context.getStore(BENCHMARK_NAMESPACE).put(startTimeKey, currentTimeMillis());
    }

    private void report(String unit, ExtensionContext context, long duration) {
        String message = format("%s '%s' ran in %d millis.", unit, context.getDisplayName(), duration);
        context.publishReportEntry("Benchmark", message);
    }

    private enum StartTimeKey {
        SINGLE_TEST, WHOLE_TEST_CLASS
    }

}
