import com.exceptions.OutOfBoundariesException;
import org.junit.jupiter.api.*;

import static com.lesson10.Lesson10.factorialCalculation;
import static com.dataForTests.DataOutOfBounds.*;

@DisplayName("Граничное тестирование (0-100)")
class BoundariesTest {

    @Tag("0")
    @Nested
    class firstBoundary {
        @Tag("-1")
        @Test
        void lessThenMinValueTest() {
            OutOfBoundariesException e = Assertions.assertThrows(OutOfBoundariesException.class, () -> factorialCalculation(-1));
            Assertions.assertEquals(getLESS_THEN_MIN_VALUE(), e.getMessage());
        }

        @Tag("0")
        @Test
        void MinValueTest() {
            try {
                Assertions.assertEquals(getMIN_VALUE(), factorialCalculation(0));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Tag("1")
        @Test
        void aboveMinValueTest() {
            try {
                Assertions.assertEquals(getABOVE_MIN_VALUE(), factorialCalculation(1));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Tag(("100"))
    @Nested
    class SecondBoundary {
        @Tag("99")
        @Test
        void belowMaxValueTest() {
            try {
                Assertions.assertEquals(getBELOW_MAX_VALUE(), factorialCalculation(99));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Tag("100")
        @Test
        void maxValueTest() {
            try {
                Assertions.assertEquals(getMAX_VALUE(), factorialCalculation(100));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Tag("101")
        @Test
        void aboveMaxValueTest() {
            OutOfBoundariesException e = Assertions.assertThrows(OutOfBoundariesException.class, () -> factorialCalculation(101));
            Assertions.assertEquals(getABOVE_MAX_VALUE(), e.getMessage());
        }
    }
}
