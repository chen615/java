
import java.util.Arrays;

public class Shuzu
{
    public static void main(String args[])
    {
        /*
        String[] str_array = new String[5];
        String array_string = Arrays.toString(str_array);
        
        System.out.println(array_string);
        
        String[] str = {"a", "b", "c", "d", "e"};
        System.out.println(Arrays.toString(str));
        */
        
        String str = "102";
        boolean res = str.equals("102");
        if(res) {
            System.out.println("Ok");
        }
        System.out.println(str.length());
        System.out.println(str.charAt(1));
    }
}