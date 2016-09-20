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

    public String getDM(String value){
        return String.format("select %s.%s from %s where %s.%s like \'%%%s%%\'", tb,dm, tb, tb,mc,value);
    }

}
