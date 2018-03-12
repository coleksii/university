package our.best.university;

import our.best.university.Actions.*;
import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

/**
 * Factory pattern
 */
public class FactoryAction {

    public Action getAction(Question question){
        Action action = null;

        switch (question.getQuestionCode()) {
            case 1:
                action = Action1.getInstance();
                break;
            case 2:
                action = Action2.getInstance();
                break;
            case 3:
                action = Action3.getInstance();
                break;
            case 4:
                action = Action4.getInstance();
                break;
            case 5:
                action = Action5.getInstance();
                break;
        }
        return action;
    }
}
