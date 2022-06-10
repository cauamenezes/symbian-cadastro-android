package com.example.symbian_cadastro_clientes.remote;

import com.example.symbian_cadastro_clientes.model.Cliente;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RouterInterface {

    @POST("/cliente/cadastrarCliente")
    Call<Cliente> addCliente(@Body Cliente cliente);
}
