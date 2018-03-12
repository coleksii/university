package our.best.university;

import our.best.university.Actions.*;
import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

/**
 * Factory pattern
 */
public class FactoryAction {

    /*
    nobody exactly knows how work GarbageCollector
    so we save our Actions.class in private fields to save from GC for work time our application
     */
    private static Action1 action1;
    private static Action2 action2;
    private static Action3 action3;
    private static Action4 action4;
    private static Action5 action5;

    public Action getAction(Question question){
        Action action = null;

        switch (question.getQuestionCode()) {
            case 1:
                action1 = Action1.getInstance();
                action = action1;
                break;
            case 2:
                action2 = Action2.getInstance();
                action = action2;
                break;
            case 3:
                action3 = Action3.getInstance();
                action = action3;
                break;
            case 4:
                action4 = Action4.getInstance();
                action = action4;
                break;
            case 5:
                action5 = Action5.getInstance();
                action = action5;
                break;
        }
        return action;
    }
}
