
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.Gson;

import com.cctvmall.entity.Question;

public class Db
{
    public static void main(String[] args)
    {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?useTimezone=true&serverTimezone=GMT", "root", "");
            if(!con.isClosed()) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }

            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `blog_question`");

            List<Question> questions = new ArrayList<>();
            Gson g = new Gson();

            while(rs.next()) {
                // System.out.println(rs.getInt("id"));
                // System.out.println(rs.getString("question_text"));
                Question question = new Question(rs.getInt("id"), rs.getString("question_text"), rs.getString("username"));
                questions.add(question);
            }
            con.close();
            System.out.println(g.toJson(questions));

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Db");
    }
}
