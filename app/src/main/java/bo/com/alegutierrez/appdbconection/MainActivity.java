package bo.com.alegutierrez.appdbconection;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Defining views
    private EditText editTextImei;
    private EditText editTextMacbt;
    private EditText editTextEcom;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();

        //Initializing views
        editTextImei = (EditText) findViewById(R.id.editTextImei);
        editTextMacbt = (EditText) findViewById(R.id.editTextMacbt);
        editTextEcom = (EditText) findViewById(R.id.editTextEcom);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);

        //-------------------------------------------------------- obtener direccion bluetooth
        String macAddress = android.provider.Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
        if(macAddress == null){

            Random r = new Random();
            int num = r.nextInt(99);

            macAddress = "50:"+  num +":0A:FE:23:8D";// este es una mac fake

        }
        //Toast.makeText(MainActivity.this,macAddress,Toast.LENGTH_LONG).show();

        editTextMacbt.setText(macAddress);
        editTextMacbt.setEnabled(false);// evita que se edite este campo de texto

        //-------------------------------------------------------obtener codigo imei

        String imeiDevice = getImei();
        Toast.makeText(MainActivity.this, imeiDevice, Toast.LENGTH_LONG).show();

        editTextImei.setText(imeiDevice);
        editTextImei.setEnabled(false);



    }



    // devuelve lel codigo imei del dispositivo
    public String getImei() {

        Context context = this.getApplicationContext();

        String identifier = null;
        TelephonyManager tm = (TelephonyManager)context.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null)
            identifier = tm.getDeviceId();
        if (identifier == null || identifier .length() == 0)
            identifier = Settings.Secure.getString(context.getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        return identifier;
    }


    //Adding elemeto en la tabla de empleados
    private void addEcom(){

        final String imei = editTextImei.getText().toString().trim();
        final String macbt = editTextMacbt.getText().toString().trim();
        final String ecom = editTextEcom.getText().toString().trim();

        class AddEcom extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Registrando ECOM...","Espere...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_IMEI,imei);
                params.put(Config.KEY_EMP_MACBT,macbt);
                params.put(Config.KEY_EMP_ECOM,ecom);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEcom ae = new AddEcom();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            //addEmployee();
            addEcom();
        }

        if(v == buttonView){
            //Toast.makeText(MainActivity.this,"Hola",Toast.LENGTH_LONG).show();
            //startActivity(new Intent(this,ViewAllEmployee.class));
            //Intent intent = new Intent(this,ViewAllEmployee.class );
            //startActivity(intent);
        }
    }

    // obtener mac bluetooth

}
