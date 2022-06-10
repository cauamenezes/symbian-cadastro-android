package com.example.symbian_cadastro_clientes.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.30:3000/";

    public  static RouterInterface getClienteInterface(){

        return RetrofitClient.getClient(API_URL)
                .create(RouterInterface.class);

    }
}
