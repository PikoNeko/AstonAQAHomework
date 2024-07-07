import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static com.lesson10.Lesson10.factorialCalculation;
import com.exceptions.OutOfBoundariesException;

import java.math.BigInteger;

public class BoundariesTest {

    @Test(
            description = "-1",
            expectedExceptions = OutOfBoundariesException.class,
            expectedExceptionsMessageRegExp = "Нельзя вычислять факториал отрицательных чисел!")
    void belowMinValueTest() throws OutOfBoundariesException {
        factorialCalculation(-1);
    }

        @Test(description = "0")
        @Parameters("minValue")
        void MinValueTest(int value) {
            try {
                assertEquals(BigInteger.valueOf(value), factorialCalculation(0));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }

        }

        @Test(description = "1")
        @Parameters("aboveMinValue")
        void aboveMinValueTest(String value) {
            try {
                BigInteger localValue = new BigInteger(value);
                assertEquals(localValue, factorialCalculation(1));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Test(description = "99")
        @Parameters("belowMaxValue")
        void belowMaxValueTest(String value) {
            try {
                BigInteger localValue = new BigInteger(value);
                assertEquals(localValue, factorialCalculation(99));
            } catch (OutOfBoundariesException e) {
                throw new RuntimeException(e);
            }
        }

        @Test(description = "100")
        @Parameters("maxValue")
        void maxValueTest( String value) {
            try {
                BigInteger localValue = new BigInteger(value);
                assertEquals(localValue, factorialCalculation(100));
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
