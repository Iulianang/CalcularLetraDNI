package edu.calcularletradni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mostrarToas (String letra){
        Toast toast = Toast.makeText(this, "Su letra es: "+letra,Toast.LENGTH_LONG);
        toast.show();
    }

    public void calcularDNI (View vista){

        EditText editText = (EditText)findViewById(R.id.numeros_dni);
        String dni = editText.getText().toString();

        ObtenerLetraDNI obtenerLetraDNI = new ObtenerLetraDNI(this);
        obtenerLetraDNI.execute(dni); // execute es un metodo que llama a doInBackground



    }
}
