
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Categories.IncludeCategory(ArithmeticTestGroup.class)
@Suite.SuiteClasses({
        CalculatorTests.class,

})
public class TestSuite {

}