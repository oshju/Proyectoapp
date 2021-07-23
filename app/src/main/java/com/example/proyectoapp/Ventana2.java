package com.example.proyectoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ventana2 extends AppCompatActivity {
    private Button btnlogin;
    private EditText caja1;
    private EditText caja2;
    private EditText caja3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana2);
        this.btnlogin=findViewById(R.id.btnlogin);
        this.caja1=findViewById(R.id.txtnombre);
        this.caja2=findViewById(R.id.txtapellido);
        this.caja3=findViewById(R.id.txtemail);

    }
    public void mostrarFormulario(View view) {
        Intent i = new Intent(this, Ventana3.class );
        startActivity(i);
    }

    public void toast() {
        Context context = getApplicationContext();
        CharSequence text = "Registro realizado!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void toast1() {
        Context context = getApplicationContext();
        CharSequence text = "Registro no realizado!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}