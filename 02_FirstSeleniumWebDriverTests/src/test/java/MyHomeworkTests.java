import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

public class MyHomeworkTests {

    // Тест 1: Проверка возврата 100% при отмене концерта
    @Test
    public void test100PercentRefundOnConcertCancellation() {
        Integer percent = MyHomeworkTests.getRefundTicketPricePercent(10, true, false);
        Assertions.assertEquals(100, percent);
    }

    // Тест 2: Проверка возврата 100% при переносе концерта
    @Test
    public void test100PercentRefundOnConcertRescheduling() {
        Integer percent = MyHomeworkTests.getRefundTicketPricePercent(10, false, true);
        Assertions.assertEquals(100, percent);
    }

    // Тест 3: Проверка возврата 100% если отмена и перенос
    @Test
    public void test100PercentRefundOnConcertCancellationAndRescheduling() {
        Integer percent = MyHomeworkTests.getRefundTicketPricePercent(10, true, true);
        Assertions.assertEquals(100, percent);
    }

    // Тест 4: Проверка возврата 0% при ближайшем концерте
    @Test
    public void test0PercentRefundForUpcomingConcert() {
        Integer percent = MyHomeworkTests.getRefundTicketPricePercent(5, false, false);
        Assertions.assertEquals(0, percent);
    }

    // Тест 5: Проверка возврата 50% при концерте через 4 дня
    @Test
    public void test50PercentRefundForConcertIn4Days() {
        Integer percent = MyHomeworkTests.getRefundTicketPricePercent(96, false, false);
        Assertions.assertEquals(30, percent);
    }


    private static Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)
    {
        if(wasConcertCancelled || wasConcertRescheduled) return 100;
        if(hoursBeforeConcert > 240) return 100;
        if(hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if(hoursBeforeConcert >= 6 && hoursBeforeConcert < 144) return 30;
        return 0;
    }


    @Test
    public void testGetMarkResult() {
        MyHomeworkTests homework = new MyHomeworkTests();

        // Тестирование оценки "2"
        assertEquals("2", homework.getMarkResult(0));
        assertEquals("2", homework.getMarkResult(35));

        // Тестирование оценки "3"
        assertEquals("3", homework.getMarkResult(36));
        assertEquals("3", homework.getMarkResult(56));

        // Тестирование оценки "4"
        assertEquals("4", homework.getMarkResult(57));
        assertEquals("4", homework.getMarkResult(71));

        // Тестирование оценки "5"
        assertEquals("5", homework.getMarkResult(72));
        assertEquals("5", homework.getMarkResult(100));
    }

    private String getMarkResult(Integer mark)
    {
        if(mark >= 0 && mark < 36) return "2";
        if(mark >= 36 && mark < 57) return "3";
        if(mark >= 57 && mark <= 71) return "4";
        if(mark >= 72 && mark <= 100) return "5";
        return "no mark result";
    }

}
