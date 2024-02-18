import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MyHomeworkAppraisalTest {

    @Test
    public void GetMarkResultTest() {
        MyHomeworkAppraisalTest homework = new MyHomeworkAppraisalTest();

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
