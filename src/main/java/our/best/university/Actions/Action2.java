package our.best.university.Actions;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

    /**
     * this class is a singletone pattern
     * create only once and only if we need do this Action
     */
public class Action2 extends Action{
    private static volatile Action2 instance;

    public static Action2 getInstance() {
        Action2 localInstance = instance;
        if (localInstance == null) {
            synchronized (Action2.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Action2();
                }
            }
        }
        return localInstance;
    }

    private Action2(){
        query = "SELECT lectors.degree, COUNT(degree) FROM university.lect_and_dep\n" +
                "inner JOIN lectors on lect_and_dep.id_lector=lectors.lectorsId\n" +
                "inner JOIN departmens on lect_and_dep.id_departmen=departmens.DepartmenId\n" +
                "where departmenName=?\n" +
                "group by degree;";
    }

    @Override
    protected void printResult(ResultSet resultSet, Question question){
        int answer;
        String degree;
        boolean flag = false;
        try {
            while (resultSet.next()){
                answer = resultSet.getInt(2);
                degree = resultSet.getString(1) + "s";
                System.out.println(degree + " - " + answer);
                flag = true;
            }
            if (flag == false)
                System.out.println("Unfortunately this department have no any employees or it does not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
