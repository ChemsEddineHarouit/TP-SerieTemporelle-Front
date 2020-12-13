package com.chems.Serietemporelle.tp.routes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsersRoutes {
    @Value("${app.b_server}")
    private String B_SERVER = "http://localhost:8080/";
    private static UsersRoutes instance;

    private UsersRoutes(){}

    public static final UsersRoutes getInstance(){
        if (instance == null){
            instance = new UsersRoutes();
        }
        return instance;
    }

    public  String getListUrl(){return B_SERVER + "users/";}

    public  String getFindByIdUrl(String id){
        return B_SERVER + "users/"+id;
    }

    public  String getCreateUrl(){
        return B_SERVER + "users/";
    }
}
