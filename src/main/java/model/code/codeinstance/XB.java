package model.code.codeInstance;

import model.code.CodeTb;

/**
 * Created by xliu on 2016/9/20.
 */
public class XB extends CodeTb {
    public XB(){
        this.tb ="js_xb";
        this.dm="bm";
        this.mc="mc";
    }
    public XB(String tb){
        this.tb = tb;
    }

    public String getDM(String value){
        return String.format("select %s.%s from %s where %s.%s like \'%%%s%%\'", tb,dm, tb, tb,mc,value);
    }

}
