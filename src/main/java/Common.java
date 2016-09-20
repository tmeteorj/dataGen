/**
 * Created by Administrator on 2016/9/20.
 */
public class Common {
    public static String getEqual(String attr,String value){
        return String.format(" %s=\'%s\'",attr,value);
    }
    public static String  getLike(String attr,String value){
        return String.format(" %s like \'%%%s%%\'",attr,value);
    }
    public static void main(String args[]){
        System.out.println(getLike("xbbm","男"));
    }
}
