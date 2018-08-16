import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.POITextExtractor;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {


    /**
     * 读取doc 、docx文件内容
     * @param ad 想要读取的文件对象的地址
     * @return 返回文件内容
     * 参考 ：https://blog.csdn.net/qq_20389175/article/details/44058209
     *      http://elim.iteye.com/blog/2049110
     */
    public static String doc2String(String ad){
        StringBuffer content=new StringBuffer();
        try{

            if(ad.contains(".docx")){
                InputStream is = new FileInputStream(ad); //文件流
                XWPFDocument docx = new XWPFDocument(is);
                XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
                //提取.docx正文文本
                String text = extractor.getText();
                content.append(text.replaceAll("\r"," ")
                        .replaceAll("\n"," ")
                        .replaceAll("\t"," "));
                is.close();
            }else if(ad.contains(".doc")){
                File file = new File(ad);
                FileInputStream fis = new FileInputStream(file); //文件流
                HWPFDocument doc = new HWPFDocument(fis);
                //提取.doc正文文本
                StringBuilder text = doc.getText();
                content.append(text.toString().replaceAll("\r"," ")
                        .replaceAll("\n"," ")
                        .replaceAll("\t"," "));
                fis.close();
            }else{
                throw  new Exception("文件格式有问题，不是doc或docx文档");
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return content.toString();
    }


    /**
     * 是否是英文
     *
     * @param charaString
     * @return
     */

    public static boolean isEnglish(String charaString) {
        return charaString.matches("^[a-zA-Z]*");
    }

    /**
     * 是否是中文
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        String regEx = "[\\u4e00-\\u9fa5]+";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find())
            return true;
        else
            return false;
    }

    /*
    * 根据文章内容和关键字，进行匹配
    *参考 http://www.runoob.com/java/java-regular-expressions.html   http://mfan.iteye.com/blog/1025473
    * */
    public static int countKeyWord(String text,String keyWord){
        int num = 0;
        /*判断关键字类型，是中文还是英文*/
        if(isEnglish(keyWord)){             /*英文关键字.进行正则匹配*/
            keyWord=keyWord.toLowerCase();  //转化为小写
            //String REGEX = "\\b"+keyWord+"\\b";     /*正则匹配，找出某个单词*/
            String REGEX = "\\d+.\\d+|\\w+";     /*正则匹配  找出所有的英文单词,*/
            Pattern p = Pattern.compile(REGEX);
            Matcher m = p.matcher(text);            // 获取 matcher 对象
            while(m.find()) {                               /*对每个单词进行匹配*/
                if(m.group().toLowerCase().equals(keyWord))
                    num++;
            }
        }else if(isChinese(keyWord)){       /*中文关键字*/
            String[] array=text.split(keyWord);//划分
            num=array.length-1;
        }
        return num >= 0 ? num : 0;
    }

    public static void main(String[] args)throws IOException {
        String ad= "D:\\work\\file\\bb.doc";
//        String ad= "D:\\work\\file\\gg.docx";

        String res=doc2String(ad);                          /*获取doc内容*/
        System.out.println( res );
        do{
            System.out.println( "**********************" );
            System.out.println( "请输入关键字(不能出现空格):" );
            Scanner s = new Scanner(System.in);
            String keyWord = s.next();
            keyWord=keyWord.trim();                             /*去除两边的空格*/
            int num=countKeyWord(res.toLowerCase(),keyWord);    /*匹配关键字*/
            System.out.println("关键字:"+ keyWord );
            System.out.println( "匹配个数为:" + num );
        }while(true);
       // String keyWord="When";

    }
}
