package our.best.university.logic;

public class Question {
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

    private String name;
    private int questionCode = 0;
}
