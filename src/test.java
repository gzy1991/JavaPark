import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gzy on 2018/5/17.
 */
public class test {
    public static void main(String[] args){
        String signDeptCode = "020036";
        if(signDeptCode != "020008" && signDeptCode != "020036" && signDeptCode != "020093" && signDeptCode != "020020"){
            //2、(合同金额≥100万，合同类别是技术开发、技术服务、监理的合同) || (合同金额≥500万，合同类别是系统集成、销售订单、产品销售、综合的合同)
            System.out.println("in");
        }

        System.out.println("out");
        if("020008".equals(signDeptCode) &&  "020036".equals(signDeptCode) && "020093".equals(signDeptCode) &&  "020020".equals(signDeptCode)){
            //2、(合同金额≥100万，合同类别是技术开发、技术服务、监理的合同) || (合同金额≥500万，合同类别是系统集成、销售订单、产品销售、综合的合同)
            System.out.println("in2");
        }
        System.out.println("out2");

    }
}
