package our.best.university.Actions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import our.best.university.DBWorker;
import our.best.university.logic.Question;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
/*
test passed only with only with this database of this data - i know, its not really good
 */
public class TestActions {

    private DBWorker dbWorker;
    private Question question;
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final String separator = System.getProperty("line.separator");

    public TestActions() {
        this.dbWorker = new DBWorker();
        this.question = new Question();
    }

    @Before
    public void test(){
        try {
            System.setOut(new PrintStream(output, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAction1() {
        Action1 action1 = Action1.getInstance();

        question.setName("Gryffindor");
        String diff = "Head of Gryffindor department is McGonagall" + separator;
        action1.action(dbWorker, question);
        assertEquals(output.toString(), diff);
    }

    @Test
    public void testAction2() {
        Action2 action2 = Action2.getInstance();

        question.setName("Gryffindor");
        String diff = "assistants - 1" + separator + "professors - 2" + separator;
        action2.action(dbWorker, question);
        assertEquals(output.toString(), diff);
    }

    @Test
    public void testAction3() {
        Action3 action3 = Action3.getInstance();

        question.setName("Gryffindor");
        String diff = "The average salary of Gryffindor is 3500" + separator;
        action3.action(dbWorker, question);
        assertEquals(output.toString(), diff);
    }

    @Test
    public void testAction4() {
        Action4 action4 = Action4.getInstance();

        question.setName("Gryffindor");
        String diff = "3" + separator;
        action4.action(dbWorker, question);
        assertEquals(output.toString(), diff);
    }

    @Test
    public void testAction5() {
        Action5 action5 = Action5.getInstance();

        question.setName("%al%");
        String diff = "Albus Dumbledore, Minerva McGonagall" + separator;
        action5.action(dbWorker, question);
        assertEquals(output.toString(), diff);
    }

    @Test
    public void testFailAction1() {
        Action1 action1 = Action1.getInstance();

        question.setName("some random");
        String diff = "Unfortunately this department does not exist" + separator;
        action1.action(dbWorker, question);
        assertEquals(output.toString(), diff);
    }

    @After
    public void after(){
        System.setOut(stdout);

    }
}

