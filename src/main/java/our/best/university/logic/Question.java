package our.best.university.logic;

    /**
     * class that save action's code
     * and name of Department or template for lectors
     */
public class Question {

    private String name;
    private int questionCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuestionCode() {
        return questionCode;
    }

    public void setQuestionCode(int questionCode) {
        this.questionCode = questionCode;
    }

    public Question(){
        super();
    }

    public Question(String name, int questionCode) {
        super();
        this.name = name;
        this.questionCode = questionCode;
    }
}
