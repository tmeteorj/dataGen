package model.event.eventInstance;

import java.util.ArrayList;

import model.event.EventTb;

/**
 * Created by xliu on 2016/9/20.
 */
public class TIELU extends EventTb{
    public static String les[]={"train_date","coach_no","seat_no"};
    public static String bgs[]={"train_date","coach_no","seat_no"};
    public static String eqs[]={"train_date","coach_no","seat_no"};
    public static String lks[]={"id_name","from_station_name","to_station_name"};

    public TIELU(){
        this.tb ="js_tielu";
        this.id ="id_no";
    }
    public TIELU(String tb){
        this.tb = tb;
        this.id ="id_no";
    }

}
