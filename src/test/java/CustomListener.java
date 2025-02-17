import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class CustomListener extends RunListener {
    @Override
    public void testRunStarted(Description description) {
        System.out.println("Test Run Started: " + description.getDisplayName());
    }

    @Override
    public void testRunFinished(Result result) {
        System.out.println("Test Run Finished. Total tests: " + result.getRunCount() +
                ", Failures: " + result.getFailureCount() +
                ", Ignored: " + result.getIgnoreCount());
    }

    @Override
    public void testStarted(Description description) {
        System.out.println("Running Test: " + description.getMethodName());
    }

    @Override
    public void testFinished(Description description) {
        System.out.println("Finished Test: " + description.getMethodName());
    }



    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println(failure.getDescription());
    }


    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("Finished Test: " + description.getMethodName());

    }


}