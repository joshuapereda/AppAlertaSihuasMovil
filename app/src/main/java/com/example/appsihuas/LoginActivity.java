package com.example.appsihuas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appsihuas.client.ApiClient;
import com.example.appsihuas.entity.LoginRequest;
import com.example.appsihuas.entity.LoginResponse;
import com.example.appsihuas.service.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.txtEmail);
        etPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btninicioSesion);

        // Configurar los márgenes del layout principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar el clic del texto "¿Eres nuevo? ¡Regístrate!"
        TextView nuevoUsuario = findViewById(R.id.nuevoUsuario);
        nuevoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un intento para navegar a la actividad de registro
                Intent intent = new Intent(LoginActivity.this, SingUpActivity.class);
                startActivity(intent);
                finish(); // Finalizar la actividad actual
            }
        });

        // Configurar el clic del texto "¿Olvidaste tu Contraseña?"
        TextView olvidasteContra = findViewById(R.id.olvidasteContra);
        olvidasteContra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear un intento para navegar a la actividad de recuperar contraseña
                Intent intent = new Intent(LoginActivity.this, OlvidarcontrasenaActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (!email.isEmpty() && !password.isEmpty()) {
                    login(email, password);
                } else {
                    Toast.makeText(LoginActivity.this, "Por favor completa los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void login(String email, String password) {
        // Crear una instancia de ApiInterface
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        // Crear un objeto LoginRequest que contenga el email y la contraseña
        LoginRequest loginRequest = new LoginRequest(email, password);

        // Llamar al método login de la API
        Call<LoginResponse> call = apiInterface.login(loginRequest);

        // Realizar la solicitud asincrónica
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                // Verificar si la respuesta fue exitosa
                if (response.isSuccessful() && response.body() != null) {
                    // Verificar si el login fue exitoso
                    if (response.body().getToken() != null) {
                        String token = response.body().getToken();
                        Toast.makeText(LoginActivity.this, "Login exitoso", Toast.LENGTH_SHORT).show();

                        // Almacenar el token de autenticación (por ejemplo, en SharedPreferences)
                        SharedPreferences sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("token", token);
                        editor.apply();

                        // Redirigir a otra actividad después de login
                        Intent intent = new Intent(LoginActivity.this, BottomActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // En caso de que la respuesta no contenga el token
                        Toast.makeText(LoginActivity.this, "Login fallido: " + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Si hubo un problema con la respuesta del servidor
                    Toast.makeText(LoginActivity.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // En caso de error en la conexión o fallo en la solicitud
                Log.e("LoginError", t.getMessage());
                Toast.makeText(LoginActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
