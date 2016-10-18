
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;

import com.cctvmall.entity.Human;
import com.cctvmall.entity.Person;

public class Hello
{
    public static void main(String[] args)
    {
        /*
        System.out.println("Chen Jian Ping");
        int a = 5;
        a = a + 1;
        System.out.println(a);
        */
        Human human = new Human();
        human.Hu();
        List<String> humanlist = human.tasks();
        Iterator<String> iter = humanlist.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        Gson g = new Gson();
        String json = g.toJson(humanlist);
        System.out.println(json);

        List<Person> list = new ArrayList<>();
        int i = 3;
        while(i > 0) {
            Person p = new Person(i, "chen jian ping", "BeiJin");
            list.add(p);
            i--;
        }
        System.out.println(g.toJson(list));

    }
}

