package our.best.university.Actions.AbstractAction;

import our.best.university.DBWorker;
import our.best.university.logic.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Action {
    protected String query;

    /**
     * this method create prepare statement with correctly query and execute it
     */
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

    /**
     * pulls out result from resultSet
     */
    protected void printResult(ResultSet resultSet, Question question){

    }
}
