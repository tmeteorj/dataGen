package model.code.codeInstance;

import model.code.CodeTb;

/**
 * Created by xliu on 2016/9/20.
 */
public class HCZ extends CodeTb {
    public HCZ(){
        this.tb ="js_hcz";
        this.dm="bh";
        this.mc="zm";
    }
    public HCZ(String tb){
        this.tb = tb;
        this.dm="bh";
        this.mc="zm";
    }

    public String getDM(String value){
        return String.format("select %s.%s from %s where %s.%s like \'%%%s%%\'", tb,dm, tb, tb,mc,value);
    }

}
