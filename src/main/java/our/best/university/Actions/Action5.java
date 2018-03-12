package our.best.university.Actions;

import our.best.university.Actions.AbstractAction.Action;
import our.best.university.DBWorker;
import our.best.university.logic.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Action5 extends Action {

    private static volatile Action5 instance;

    public static Action5 getInstance() {

        Action5 localInstance = instance;
        if (localInstance == null) {
            synchronized (Action5.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Action5();
                }
            }
        }
        return localInstance;
    }

    private Action5(){
        query = "select name, lastname from lectors\n" +
                "WHERE name LIKE ? or lastname LIKE ?";
    }

    /*
    this only action, that must have two unknown parameters '?' at query prepare statement,
    so its only one action, that have override action() method
     */

    @Override
    public void action(DBWorker dbWorker, Question question){
        try {
            PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
            statement.setString(1, question.getName());
            statement.setString(2, question.getName());
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            printResult(resultSet, question);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                if (flag)
                    System.out.print(", ");
                System.out.print(name + " " + lastname);
                flag = true;
            }
            if (flag == false)
                System.out.println("Unfortunately there are no such people in our university");
            else
                System.out.println();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
