
package time;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@SelectClasses({
      WalkingBoardTestSuite.StructuralTests.class
    , WalkingBoardTestSuite.FunctionalTests.class
})
@Suite public class TimeTestSuite {
    @SelectClasses({
        WalkingBoardStructureTest.class
    })
    @Suite public static class StructuralTests {}

    @SelectClasses({
        WalkingBoardTest.class
    })
    @Suite public static class FunctionalTests {}
}
