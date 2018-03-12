package our.best.university.logic;

public class Parsing {

    /**
     * its looks scary
     * parsing lines and save correct result in Question
     */
    public Question analysisLine(String nextLine){
        Question question = new Question();
        question.setName("");
        question.setQuestionCode(0);

        if (nextLine.indexOf("Who is head of department ") == 0){
            question.setQuestionCode(1);
            question.setName(nextLine.substring(26));
        }
        else if (nextLine.indexOf("Show ") == 0 && nextLine.indexOf(" statistic") == nextLine.length() - 10){
            question.setQuestionCode(2);
            question.setName(nextLine.substring(5, nextLine.length() - 10));
        }
        else if (nextLine.indexOf("Show the average salary for department ") == 0){
            question.setQuestionCode(3);
            question.setName(nextLine.substring(39));
        }
        else if (nextLine.indexOf("Show count of employee for ") == 0){
            question.setQuestionCode(4);
            question.setName(nextLine.substring(27));
        }
        else if (nextLine.indexOf("Global search by") == 0){
            question.setQuestionCode(5);
            question.setName("%"+nextLine.substring(17)+"%");
        }
        else if (!nextLine.equals("END") && !nextLine.isEmpty())
            System.out.println("you type wrong command, try again");
        return question;
    }
}
