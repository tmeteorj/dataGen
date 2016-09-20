package common;

import model.Description;
import sun.security.krb5.internal.crypto.Des;

/**
 * Created by xliu on 2016/9/20.
 */
public class Complex {

    public static String aWithB(Description a,Description b){
        String da=Simple.getGMSFHM(a);
        String db=Simple.getGMSFHM(b);
        return String.format("%s and %s.%s in ( %s )",da,a.tb,a.id,db);
    }
    public static void main(String args[]){
        Description rk=Description.randomDescription("js_rkxx");
        Description fz=Description.randomDescription("js_fzryxx");
        Description tl=Description.randomDescription("js_tielu");
        System.out.println(aWithB(tl,rk));
    }
}
