package edu.calcularletradni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularDNI (View vista){

        EditText editText = (EditText)findViewById(R.id.numeros_dni);
        String dni = editText.getText().toString();

        ObtenerLetraDNI obtenerLetraDNI = new ObtenerLetraDNI();
        obtenerLetraDNI.execute(dni); // execute es un metodo que llama a doInBackground



    }
}
