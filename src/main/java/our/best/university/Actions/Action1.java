package our.best.university.Actions;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.logic.Question;

import java.sql.ResultSet;
import java.sql.SQLException;

    /**
     * this class is a singletone pattern
     * create only once and only if we need do this Action
     */
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
        super();
        query = "SELECT name, lastname FROM university.departmens\n" +
                "inner join lectors on id_head=lectorsid\n" +
                "where DepartmenName=?;";
    }

    @Override
    protected void printResult(ResultSet resultSet, Question question){
        String name;
        String lastname;
        boolean flag = false;
        try {
            while (resultSet.next()){
                name = resultSet.getString(1);
                lastname = resultSet.getString(2);
                System.out.println("Head of " + question.getName() + " department is " + name + " " + lastname);
                flag = true;
            }
            if (flag == false)
                System.out.println("Unfortunately this department does not exist");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
