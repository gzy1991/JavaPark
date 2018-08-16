import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 在字符串中查找匹配的子字符串
 * author：大能豆   QQ：1023507448
 * case ：
 *      源字符串：You may be out of my sight, but never out of my mind.
 *      要查找的子字符串：my
 *      输出：匹配个数为2
 */
public class matchString {

    //方法1、通过String的indexOf(String str, int fromIndex)方法
    private void matchStringByIndexOf( String parent,String child )
    {
        int count = 0;
        int index = 0;
        while( ( index = parent.indexOf(child, index) ) != -1 )
        {
            index = index+child.length();
            count++;
        }
        System.out.println( "匹配个数为"+count );                              //结果输出
    }

    //方法2、通过正则表达式
    private void matchStringByRegularExpression( String parent,String child )
    {

        int count = 0;
        Pattern p = Pattern.compile( child );
        Matcher m = p.matcher(parent);
        while( m.find() )
        {
            count++;
            System.out.println( "匹配项" + count+"：" + m.group() ); //group方法返回由以前匹配操作所匹配的输入子序列。
        }
        System.out.println( "匹配个数为"+count );                              //结果输出
    }

    //方法3、通过split方法
    private void matchStringBySplit( String parent,String child )
    {
        String[] array = parent.split(child);
        System.out.println( "匹配个数为" + (array.length-1) );
    }

    public static void main(String[] args)
    {
        matchString ms = new matchString();
        String parent = "You may be out of my sight, but never out of my mind.";
        String child = "my";

        System.out.println( "------通过indexOf-------" );
        ms.matchStringByIndexOf( parent,child );  //调用方法1

        System.out.println( "------通过正则表达式-------" );
        ms.matchStringByRegularExpression( parent,child );  //调用方法2

        System.out.println( "------通过split方法-------" );
        ms.matchStringBySplit( parent,child );  //调用方法3


    }

}