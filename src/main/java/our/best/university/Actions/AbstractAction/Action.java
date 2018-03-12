package our.best.university.Actions.AbstractAction;

import our.best.university.DBWorker;
import our.best.university.logic.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Action {
    //todo выгруать не все данные из БД
    protected String query;

    public void action(DBWorker dbWorker, Question question){
        try {
            PreparedStatement statement = dbWorker.getConnection().prepareStatement(query);
            statement.setString(1, question.getName());
            statement.execute();
            ResultSet resultSet = statement.getResultSet();
            printResult(resultSet, question);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void printResult(ResultSet resultSet, Question question){

    }
}
