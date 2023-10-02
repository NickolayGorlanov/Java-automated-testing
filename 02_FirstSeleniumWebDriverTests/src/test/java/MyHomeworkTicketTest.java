import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MyHomeworkTicketTest {

    // Тест 1: Проверка возврата 100% при отмене концерта
    @Test
    public void PercentRefundOnConcertCancellation100Test() {
        Integer percent = MyHomeworkTicketTest.getRefundTicketPricePercent(10, true, false);
        Assertions.assertEquals(100, percent);
    }

    // Тест 2: Проверка возврата 100% при переносе концерта
    @Test
    public void PercentRefundOnConcertRescheduling100Test() {
        Integer percent = MyHomeworkTicketTest.getRefundTicketPricePercent(10, false, true);
        Assertions.assertEquals(100, percent);
    }

    // Тест 3: Проверка возврата 100% если отмена и перенос
    @Test
    public void PercentRefundOnConcertCancellationAndRescheduling100Test() {
        Integer percent = MyHomeworkTicketTest.getRefundTicketPricePercent(10, true, true);
        Assertions.assertEquals(100, percent);
    }

    // Тест 4: Проверка возврата 0% при ближайшем концерте
    @Test
    public void PercentRefundForUpcomingConcert0Test() {
        Integer percent = MyHomeworkTicketTest.getRefundTicketPricePercent(5, false, false);
        Assertions.assertEquals(0, percent);
    }

    // Тест 5: Проверка возврата 50% при концерте через 4 дня
    @Test
    public void PercentRefundForConcertIn4Days50Test() {
        Integer percent = MyHomeworkTicketTest.getRefundTicketPricePercent(96, false, false);
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



}
