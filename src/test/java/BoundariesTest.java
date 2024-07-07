import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static com.dataForTests.DataOutOfBounds.*;
import static com.lesson10.Lesson10.factorialCalculation;
import com.exceptions.OutOfBoundariesException;

public class BoundariesTest {


    @Test(
            description = "-1",
            expectedExceptions = OutOfBoundariesException.class,
            expectedExceptionsMessageRegExp = "Нельзя вычислять факториал отрицательных чисел!")
    void lessThenMinValueTest() throws OutOfBoundariesException {
        factorialCalculation(-1);
    }

        @Test(description = "0")
        void MinValueTest() {
            try {
                assertEquals(getMIN_VALUE(), factorialCalculation(0));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }

        }

        @Test(description = "1")
        void aboveMinValueTest() {
            try {
                assertEquals(getABOVE_MIN_VALUE(), factorialCalculation(1));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Test(description = "99")
        void belowMaxValueTest() {
            try {
                assertEquals(getBELOW_MAX_VALUE(), factorialCalculation(99));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Test(description = "100")
        void maxValueTest() {
            try {
                assertEquals(getMAX_VALUE(), factorialCalculation(100));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Test(
                description = "-1",
                expectedExceptions = OutOfBoundariesException.class,
                expectedExceptionsMessageRegExp = "Слишком большое число!")
        void aboveMaxValueTest() throws OutOfBoundariesException {
            factorialCalculation(101);
        }
}
