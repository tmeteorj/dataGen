package model.code.codeInstance;

import model.code.CodeTb;

/**
 * Created by xliu on 2016/9/20.
 */
public class AJLB extends CodeTb {
    public AJLB(){
        this.tb ="js_ajlb";
        this.dm="dm";
        this.mc="mc";
    }
    public AJLB(String tb){
        this.tb = tb;
        this.dm="dm";
        this.mc="mc";
    }
    public static int idx=1;
    public String getDM(String value){
        String dms=String.format("select %s.%s from %s where %s.%s like \'%%%s%%\'", tb+idx,dm, tb+" "+tb+idx, tb+idx,mc,value);
        idx++;
        return dms;
    }
    public String getDM(String value,String attr){
        String dms=String.format("select %s.%s from %s where %s.%s like \'%%%s%%\' and %s=%s.%s", tb+idx,dm, tb+" "+tb+idx, tb+idx,mc,value,
                attr,tb+idx,dm);
        idx++;
        return dms;
    }
}
