package edu.calcularletradni;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.webkit.HttpAuthHandler;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrador on 22/03/2017.
 */

 

public class ObtenerLetraDNI extends AsyncTask<String,Void,String >{

    private static final String SERVLET_LETRA_DNI = "http://femxa-ebtm.rhcloud.com/CalcularLetraDni?dni=";

    @Override
    protected String doInBackground(String... params) {
        String letraDNI = null;
        String dni =params[0];

        HttpURLConnection http = null;


        try {

            String servicio = SERVLET_LETRA_DNI+dni;

            URL url = new URL(servicio);

            http = (HttpURLConnection) url.openConnection();

            if (http.getResponseCode()==HttpURLConnection.HTTP_OK){
                
                http.getInputStream();
                InputStream is = http.getInputStream();
                InputStreamReader isr =  new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                letraDNI = br.readLine();

            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }


        return letraDNI;


    }

    @Override
    protected void onPostExecute(String letra) {
        super.onPostExecute(letra);
        Log.d("MENSAJE", "La invocacion al servlet acabo");
        Log.d("MENSAJE", "Letra recibida = "+ letra);
    }
}
