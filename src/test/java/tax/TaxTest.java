package tax;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TaxTest {

    /* Написать метод и тесты к нему:
       Вычислить сумму налога по прогрессивной шкале в зависимости от полученного заработка:
       13% на доход до 10 000,
       20% на доход от 10 000 до 50 000,
       30% на доход выше 50 000.
       Метод должен принимать сумму оплаты труда, а возвращать сумму налога.
     */
    public double getTax(double income) {
        double tax;
        if (income < 10000) {
            tax = income * 0.13;
            return tax;
        } else if (income >= 10000 && income < 50000) {
            tax = income * 0.2;
            return tax;
        } else {
            tax = income * 0.3;
            return tax;
        }
    }

    @Test(dataProvider = "taxValue")
    public void testGetTax(double input, double expected) {
        double result = getTax(input);
        Assert.assertEquals(result, expected, "input is" + expected);
    }


    @DataProvider
    public Object[][] taxValue() {
        return new Object[][]{
                {2000, 2000 * 0.13},
                {9999, 9999 * 0.13},
                {10000, 10000 * 0.2},
                {10001, 10001 * 0.2},
                {20000, 20000 * 0.2},
                {49999, 49999 * 0.2},
                {50000, 50000 * 0.3},
                {50001, 50001 * 0.3},
                {60000, 60000 * 0.3},
        };

    }
}