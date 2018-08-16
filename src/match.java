/**
 * Created by gzy on 2018/5/11.
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class match {
    /*
    * 正则表达式中“\d”表示[0-9]的数字，“\d+”表示由[0-9]的数字组成的数字，“\w”表示[A-Z0-9]，“\w+”表示由数字、26 个英文字母或者下划线组成的字符串，“\d+.+\d+”表示小数
    * */
    public static void main(String[] args){
        String  str="11 22 33When we asks parents for money and for other things, we are so naturally to do it and without thinking too much. If our parents refuse, we will be angry. But the fact is that they don’t owe us, instead, we owes them and most of us don’t know the meaning of gratitude. Don’t take everything from our parents as a necessary. SUN公司被Oracle收购，是否意味着java被逼上了死路？";
        //String s = "\\d+.\\d+|\\w+";
        String s = "\\bwe\\b";
        Pattern  pattern=Pattern.compile(s);
        Matcher  ma=pattern.matcher(str);
        int count=0;

        while(ma.find()){
            count++;
            //String a=ma.group();
            System.out.println(ma.group());
        }
        System.out.println("个数："+count);

    }

}
