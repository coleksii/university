package our.best.university.Actions;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

    /**
     * this class is a singletone
     * create only once and only if we need do this Action
     */
public class Action3 extends Action {
    private static volatile Action3 instance;

    public static Action3 getInstance() {
        Action3 localInstance = instance;
        if (localInstance == null) {
            synchronized (Action3.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Action3();
                }
            }
        }
        return localInstance;
    }

    private Action3() {
        super();
        query = "SELECT AVG(salary) FROM university.lect_and_dep\n" +
                "inner JOIN lectors on lect_and_dep.id_lector=lectors.lectorsId\n" +
                "inner JOIN departmens on lect_and_dep.id_departmen=Departmens.DepartmenId\n" +
                "where departmenName=?;";
    }

    @Override
    protected void printResult(ResultSet resultSet, Question question){
        int answer;
        boolean flag = false;
        try {
            while (resultSet.next()){
                answer = resultSet.getInt(1);
                System.out.println("The average salary of " + question.getName() + " is " + answer);
                flag = true;
            }
            if (flag == false)
                System.out.println("Unfortunately this department have no any employees or it does not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
