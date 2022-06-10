package com.example.symbian_cadastro_clientes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.symbian_cadastro_clientes.model.Cliente;
import com.example.symbian_cadastro_clientes.remote.APIUtil;
import com.example.symbian_cadastro_clientes.remote.RouterInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText txtNome;
    EditText txtSobrenome;
    EditText txtEmail;
    EditText txtCelular;
    Button btnInserir;

    RouterInterface routerInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNome = findViewById(R.id.txtNome);
        txtSobrenome = findViewById(R.id.txtSobrenome);
        txtEmail = findViewById(R.id.txtEmail);
        txtCelular = findViewById(R.id.txtCelular);
        btnInserir = findViewById(R.id.btnCadastrarCliente);

        btnInserir.setOnClickListener(view -> {

            Cliente cliente = new Cliente();

            cliente.setNome(txtNome.getText().toString());
            cliente.setSobrenome(txtSobrenome.getText().toString());
            cliente.setEmail(txtEmail.getText().toString());
            cliente.setCelular(txtCelular.getText().toString());

            routerInterface = APIUtil.getClienteInterface();
            addCliente(cliente);

        });

    }

    public void addCliente(Cliente cliente){

        Call<Cliente> call = routerInterface.addCliente(cliente);

        call.enqueue(new Callback<Cliente>() {
            @Override
            public void onResponse(Call<Cliente> call, Response<Cliente> response) {
                Toast.makeText(MainActivity.this,
                        "Cliente inserido com sucesso!",
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Cliente> call, Throwable t) {
                Log.d("ERRO-API", t.getMessage());
            }
        });

    }
}