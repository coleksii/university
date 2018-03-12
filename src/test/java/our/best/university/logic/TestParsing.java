package our.best.university.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestParsing {
        Question question;
        Parsing parsing;

    public TestParsing() {
        question = new Question();
        parsing = new Parsing();

    }

    @Test
    public void testSimpleFailParsing(){
        question = parsing.analysisLine(";wlkmd;alwkmd");
        assertEquals(question.getQuestionCode(), 0);
        assertEquals(question.getName(), "");
    }

    @Test
    public void testParsingAction1(){
        question = parsing.analysisLine("Who is head of department 1");
        assertEquals(question.getQuestionCode(), 1);
        assertEquals(question.getName(), "1");
    }

    @Test
    public void testParsingAction2(){
        question = parsing.analysisLine("Show second statistic");
        assertEquals(question.getQuestionCode(), 2);
        assertEquals(question.getName(), "second");
    }

    @Test
    public void testParsingAction3(){
        question = parsing.analysisLine("Show the average salary for department third");
        assertEquals(question.getQuestionCode(), 3);
        assertEquals(question.getName(), "third");
    }

    @Test
    public void testParsingAction4(){
        question = parsing.analysisLine("Show count of employee for fourth");
        assertEquals(question.getQuestionCode(), 4);
        assertEquals(question.getName(), "fourth");
    }

    @Test
    public void testParsingAction5(){
        question = parsing.analysisLine("Global search by abc");
        assertEquals(question.getQuestionCode(), 5);
        assertEquals(question.getName(), "%abc%");
    }
}
