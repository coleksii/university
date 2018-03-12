package our.best.university.logic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {

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
