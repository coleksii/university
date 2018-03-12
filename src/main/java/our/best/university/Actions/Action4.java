package our.best.university.Actions;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

    /**
     * this class is a singletone pattern
     * create only once and only if we need do this Action
     */
public class Action4 extends Action{

    private static volatile Action4 instance;

    public static Action4 getInstance() {
        Action4 localInstance = instance;
        if (localInstance == null) {
            synchronized (Action4.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Action4();
                }
            }
        }
        return localInstance;
    }

    private Action4(){
        super();
        query = "SELECT COUNT(degree) FROM university.lect_and_dep\n" +
                "inner JOIN lectors on lect_and_dep.id_lector=lectors.lectorsId\n" +
                "inner JOIN departmens on lect_and_dep.id_departmen=departmens.DepartmenId\n" +
                "where departmenName=?";
    }

    @Override
    protected void printResult(ResultSet resultSet, Question question){
        int answer;
        boolean flag = false;
        try {
            while (resultSet.next()){
                answer = resultSet.getInt(1);
                System.out.println(answer);
                flag = true;
            }
            if (flag == false)
                System.out.println("Unfortunately this department have no any employees or it does not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
