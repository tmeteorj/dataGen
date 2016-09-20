package model.code.codeInstance;

import model.code.CodeTb;

/**
 * Created by xliu on 2016/9/20.
 */
public class XZQH extends CodeTb {

    public XZQH(){
        this.tb ="js_xzqh";
        this.dm="bm";
        this.mc="mc";
    }
    public XZQH(String tb){
        this.tb = tb;
        this.dm="bm";
        this.mc="mc";
    }

    public String getDM(String value){
        return String.format("select %s.%s from %s where %s.%s like \'%%%s%%\'", tb,dm, tb, tb,mc,value);
    }

}
