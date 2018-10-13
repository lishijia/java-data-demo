package lishijia.data.hive;
import org.apache.hadoop.hive.ql.exec.UDF;
/**
 * @program:
 * @description:
 * @author: lishijia
 * @create: 2018/10/13 11:06
 **/
public class UpperCassUDF extends UDF {
    public String evaluate(String input) {
        if (input == null) {
            return null;
        } else {
            return new String(input.toUpperCase());
        }
    }
}
