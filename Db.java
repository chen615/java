
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
            } */
            
            
            // 插入
            
            String sql = "INSERT INTO `blog_question`(`question_text`, `pub_date`, `username`) VALUE(?,?,?)";
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setString(1, "php");
            pr.setString(2, "2016-10-22 12:23:23");
            pr.setString(3, "Liming");
            System.out.println(pr.executeUpdate());
            pr.close();
            
            
            //修改
            /*
            String sql = "UPDATE `blog_question` SET `question_text`=?, `pub_date`=? WHERE `id`= ?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, "1234567");
            // pStmt.setDate(2, );
            pStmt.setString(2, "2016-06-24 14:59:23");
            pStmt.setInt(3, 2);
            System.out.println(pStmt.executeUpdate());
            pStmt.close(); */
            
            // 删除
            /*
            String sql = "DELETE FROM `blog_question` WHERE `id`=?";
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setInt(1, 7);
            System.out.println(pStmt.executeUpdate());
            pStmt.close(); */
            
            con.close();
            // System.out.println(g.toJson(questions));

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Db");
    }
}
