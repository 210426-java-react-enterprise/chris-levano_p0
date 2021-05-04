package com.revature.quizzard.util;

import java.sql.Connection;

public class ConnectionFactory {

    //lazy connection, requiring utilization of getInstance() method below
    private static ConnectionFactory connectionFactory; //= new ConnectionFactory();

    private ConnectionFactory() {
        //super();
    }

    public static ConnectionFactory getInstance(){
        if(connectionFactory == null){
            //return new ConnectionFactory();
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection(){
        return null;
    }

}
