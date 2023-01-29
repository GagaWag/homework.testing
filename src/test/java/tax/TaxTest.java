package tax;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TaxTest {
    double tax = 0;

    /* Написать метод и тесты к нему:
       Вычислить сумму налога по прогрессивной шкале в зависимости от полученного заработка:
       13% на доход до 10 000,
       20% на доход от 10 000 до 50 000,
       30% на доход выше 50 000.
       Метод должен принимать сумму оплаты труда, а возвращать сумму налога.
     */
    public double getTax(double income) {
        if (income < 10000) {
            this.tax = income * 0.13;
            return this.tax;
        } else if (income >= 10000 && income < 50000) {
            this.tax = income * 0.2;
            return this.tax;
        } else {
            this.tax = income * 0.3;
            return this.tax;
        }
    }

    @Test
    public void testGetTax13() {
        double result = getTax(2000);
        Assert.assertEquals(result, 2000 * 0.13, "2000*0.13");
    }

    @Test
    public void testGetTax20() {
        double result = getTax(20000);
        Assert.assertEquals(result, 20000 * 0.2, "2000*0.2");
    }

    @Test
    public void testGetTax30() {
        double result = getTax(60000);
        Assert.assertEquals(result, 60000 * 0.3, "2000*0.3");
    }
}