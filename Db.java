
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

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
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?useTimezone=true&serverTimezone=GMT&characterEncoding=utf-8", "root", "");
            if(!con.isClosed()) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
            /*
            // 查询
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM `blog_question`");

            List<Question> questions = new ArrayList<>();
            Gson g = new Gson();

            while(rs.next()) {
                // System.out.println(rs.getInt("id"));
                // System.out.println(rs.getString("question_text"));
                Question question = new Question(rs.getInt("id"), rs.getString("pub_date"), rs.getString("username"));
                questions.add(question);
            }
            */
            
            // 插入
            String sql = "INSERT INTO `blog_question`(`question_text`, `pub_date`, `username`) VALUE(?,?,?)";
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, "学习php");
            pr.setString(2, "2016-10-22 12:23:23");
            pr.setString(3, "李明");
            pr.executeUpdate();
            pr.close();
            
            con.close();
            // System.out.println(g.toJson(questions));

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Db");
    }
}
