package our.best.university.Actions;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Action1 extends Action {

    private static volatile Action1 instance;

    public static Action1 getInstance() {
        Action1 localInstance = instance;
        if (localInstance == null) {
            synchronized (Action1.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Action1();
                }
            }
        }
        return localInstance;
    }

    private Action1(){
        query = "select head from university.departmens where DepartmenName= ? ;";
    }

    @Override
    protected void printResult(ResultSet resultSet, Question question){
        String answer;
        boolean flag = false;
        try {
            while (resultSet.next()){
                answer = resultSet.getString(1);
                System.out.println("Head of " + question.getName() + " department is " + answer);
                flag = true;
            }
            if (flag == false)
                System.out.println("Unfortunately this department does not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}