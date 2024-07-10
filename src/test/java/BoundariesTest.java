import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigInteger;

import static com.lesson10.Lesson10.factorialCalculation;

import com.exceptions.OutOfBoundariesException;

@DisplayName("Граничное тестирование (0-100)")
class BoundariesTest {

    @Tag("0")
    @Nested
    class firstBoundary {
        @Tag("-1")
        @ParameterizedTest
        @ValueSource(strings = {"Нельзя вычислять факториал отрицательных чисел!"})
        void lessThenMinValueTest(String value) {
            OutOfBoundariesException e = Assertions.assertThrows(OutOfBoundariesException.class, () -> factorialCalculation(-1));
            Assertions.assertEquals(value, e.getMessage());
        }

        @Tag("0")
        @ParameterizedTest
        @ValueSource(ints = {1})
        void minValueTest(int value) throws OutOfBoundariesException {

            Assertions.assertEquals(BigInteger.valueOf(value), factorialCalculation(0));
        }

        @Tag("1")
        @ParameterizedTest
        @ValueSource(ints = {1})
        void aboveMinValueTest(int value) throws OutOfBoundariesException {

            Assertions.assertEquals(BigInteger.valueOf(value), factorialCalculation(1));
        }
    }

    @Tag(("100"))
    @Nested
    class SecondBoundary {
        @Tag("99")
        @ParameterizedTest
        @ValueSource(
                strings = {"933262154439441526816992388562667004907159682643816214685929638952175999932299156089414639761565182862536979208272237582511852109168640000000000000000000000"}
        )
        void belowMaxValueTest(String value) throws OutOfBoundariesException {

            BigInteger localValue = new BigInteger(value);
            Assertions.assertEquals(localValue, factorialCalculation(99));
        }

        @Tag("100")
        @ParameterizedTest
        @ValueSource(
                strings = {"93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"}
        )
        void maxValueTest(String value) throws OutOfBoundariesException {

            BigInteger localValue = new BigInteger(value);
            Assertions.assertEquals(localValue, factorialCalculation(100));
        }

        @Tag("101")
        @ParameterizedTest
        @ValueSource(strings = {"Слишком большое число!"})
        void aboveMaxValueTest(String value) {
            OutOfBoundariesException e = Assertions.assertThrows(OutOfBoundariesException.class, () -> factorialCalculation(101));
            Assertions.assertEquals(value, e.getMessage());
        }
    }
}
