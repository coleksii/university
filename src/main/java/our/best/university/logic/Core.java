package our.best.university.logic;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.DBWorker;
import our.best.university.FactoryAction;

import java.util.Scanner;

public class Core {
    /**
     * Heart of our application
     * that how it works:
     * 1)scanner lines
     * 2)parsing
     * 3)action(execute and print result)
     */
    public void start(){

        Question question;
        Action action;
        FactoryAction factoryAction = new FactoryAction();
        Scanner scanner = new Scanner(System.in);
        Parsing parsing = new Parsing();
        DBWorker dbWorker = new DBWorker();
        String nextLine = "";

        while (!nextLine.equals("END")) {
            nextLine = scanner.nextLine();
            question = parsing.analysisLine(nextLine);
            if (question.getQuestionCode() != 0){
                action = factoryAction.getAction(question);
                action.action(dbWorker, question);
            }
        }
        scanner.close();
    }
}
