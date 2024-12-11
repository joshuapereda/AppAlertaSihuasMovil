package com.example.appsihuas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appsihuas.client.ApiClient;
import com.example.appsihuas.entity.RegisterRequest;
import com.example.appsihuas.entity.User;
import com.example.appsihuas.entity.UserResponse;
import com.example.appsihuas.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SingUpActivity extends AppCompatActivity {

    private EditText apellidoPaterno, apellidoMaterno, nombres, tipoDoc, numDoc, celular, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);

        // Inicializa los EditText
        nombres = findViewById(R.id.nombres);
        numDoc = findViewById(R.id.numDoc);
        celular = findViewById(R.id.celular);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear el objeto User con los datos ingresados
                RegisterRequest user = new RegisterRequest();
                user.setApellido_paterno("Pereda");
                user.setApellido_materno("Iparraguirre");
                user.setNombres(nombres.getText().toString());
                user.setTipo_doc("DNI");
                user.setNum_doc(numDoc.getText().toString());
                user.setCelular(celular.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPassword(password.getText().toString());
                user.setPassword_confirmation(password.getText().toString());
                // Llamar al método registerUser
                registerUser(user);
            }
        });
    }

    private void registerUser(RegisterRequest user) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<UserResponse> call = apiService.registerUser(user);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    // Usuario registrado con éxito
                    Toast.makeText(SingUpActivity.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    // Navegar a la pantalla de inicio de sesión
                    Intent intent = new Intent(SingUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Manejar errores
                    Toast.makeText(SingUpActivity.this, "Error en el registro", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                // Manejar fallo de la solicitud
                Toast.makeText(SingUpActivity.this, "Error en la conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
