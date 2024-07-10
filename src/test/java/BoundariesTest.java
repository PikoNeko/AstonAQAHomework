import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import static com.lesson10.Lesson10.factorialCalculation;

import com.exceptions.OutOfBoundariesException;

import java.math.BigInteger;

//Тестируются граничные значения метода вычисления факториала
public class BoundariesTest {


    @Test(

            description = "-1 - тест на выход за первое граничное значение",
            expectedExceptions = OutOfBoundariesException.class,
            expectedExceptionsMessageRegExp = "Нельзя вычислять факториал отрицательных чисел!"
    )
    void belowMinValueTest() throws OutOfBoundariesException {

        factorialCalculation(-1);
    }

    @Test(description = "0 - первое граничное значение")
    @Parameters("minValue")
    void minValueTest(int value) throws OutOfBoundariesException {

        assertEquals(BigInteger.valueOf(value), factorialCalculation(0));
    }

    @Test(description = "1 - выше первого граничного значения")
    @Parameters("aboveMinValue")
    void aboveMinValueTest(String value) throws OutOfBoundariesException {

        BigInteger localValue = new BigInteger(value);
        assertEquals(localValue, factorialCalculation(1));
    }

    @Test(description = "99 - перед вторым граничным значением")
    @Parameters("belowMaxValue")
    void belowMaxValueTest(String value) throws OutOfBoundariesException {

        BigInteger localValue = new BigInteger(value);
        assertEquals(localValue, factorialCalculation(99));

    }

    @Test(description = "100 - второе граничное значение")
    @Parameters("maxValue")
    void maxValueTest(String value) throws OutOfBoundariesException {

        BigInteger localValue = new BigInteger(value);
        assertEquals(localValue, factorialCalculation(100));
    }

    @Test(
            description = "-1 - выход за второе граничное значение",
            expectedExceptions = OutOfBoundariesException.class,
            expectedExceptionsMessageRegExp = "Слишком большое число!"
    )
    void aboveMaxValueTest() throws OutOfBoundariesException {
        factorialCalculation(101);
    }
}
