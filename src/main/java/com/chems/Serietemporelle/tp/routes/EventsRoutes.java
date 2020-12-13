package com.chems.Serietemporelle.tp.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventsRoutes {
    @Value("${app.b_server}")
    private String B_SERVER = "http://localhost:8080/";
    private static EventsRoutes instance;

    private EventsRoutes(){}

    public static final EventsRoutes getInstance(){
        if (instance == null){
            instance = new EventsRoutes();
        }
        return instance;
    }

    public  String getListOfSerieTemporelleUrl(String serieTemporelleId){
        return B_SERVER + "seriestemporelles/"+ serieTemporelleId +"/events";
    }

    public  String getFindByIdUrl(String id){
        return B_SERVER + "events/"+id;
    }

    public  String getDeleteUrl(String id){
        return B_SERVER + "events/"+id;
    }

    public  String getUpdateUrl(String id){
        return B_SERVER + "events/"+id;
    }

    public  String getCreateUrl(String serieTemporelleId){
        return B_SERVER + "seriestemporelles/"+ serieTemporelleId +"/events";
    }
}
