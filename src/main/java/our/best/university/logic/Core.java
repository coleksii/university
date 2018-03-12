package our.best.university.logic;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.DBWorker;
import our.best.university.FactoryAction;

import java.util.Scanner;

public class Core {
    private String nextLine;
    private Question question;
    private Parsing parsing;
    private DBWorker dbWorker;
    private Action action;
    private FactoryAction factoryAction;

    public Core(){
        nextLine = "";
        parsing = new Parsing();
        dbWorker = new DBWorker();
        factoryAction = new FactoryAction();

    }

    public void start(){

        Scanner scanner = new Scanner(System.in);

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
