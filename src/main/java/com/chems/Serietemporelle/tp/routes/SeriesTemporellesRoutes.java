package com.chems.Serietemporelle.tp.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class SeriesTemporellesRoutes {
    @Value("${app.b_server}")
    private String B_SERVER = "http://localhost:8080/";
    private static SeriesTemporellesRoutes instance;

    private SeriesTemporellesRoutes(){}

    public static final SeriesTemporellesRoutes getInstance(){
        if (instance == null){
            instance = new SeriesTemporellesRoutes();
        }
        return instance;
    }

    public  String getListUrl(){
        return B_SERVER + "seriestemporelles/";
    }

    public  String getFindByIdUrl(String id){
        return B_SERVER + "seriestemporelles/"+id;
    }

    public  String getDeleteUrl(String id){
        return B_SERVER + "seriestemporelles/"+id;
    }

    public  String getUpdateUrl(String id){
        return B_SERVER + "seriestemporelles/"+id;
    }

    public  String getCreateUrl(String ownerId){
        return B_SERVER + "users/"+ ownerId +"/seriestemporelles/";
    }
}
