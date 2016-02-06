package mx.edu.utng.singleton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
    private EditText edtNombre;
    private EditText edtHost;
    private EditText edtPuerto;
    private Button btnCrear;
    private Button btnEditar;
    private BasedeDatos bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciarComponente();
    }
    private void iniciarComponente(){
        edtNombre = (EditText)findViewById(R.id.edt_nombre);
        edtHost = (EditText) findViewById(R.id.edt_host);
        edtPuerto = (EditText) findViewById(R.id.edt_puerto);
        btnCrear = (Button) findViewById(R.id.btn_crear);
        btnEditar = (Button)findViewById(R.id.btn_editar);
        btnEditar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            if(bd!=null){
                bd = BasedeDatos.getBd();
                bd.setNombre(edtNombre.getText().toString());
                bd.setPuerto(edtPuerto.getText().toString());
                bd.setHost(edtHost.getText().toString());
            }
                Toast.makeText(MainActivity.this,
                        "Base de datos Editada: "+bd.getNombre()+
                                "\nHost: "+bd.getHost()+
                                "\nPuerto: "+bd.getPuerto(), Toast.LENGTH_SHORT).show();
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if (bd==null){
                    bd = BasedeDatos.getBd();
                    bd.setNombre(edtNombre.getText().toString());
                    bd.setPuerto(edtPuerto.getText().toString());
                    bd.setHost(edtHost.getText().toString());
                }else{

                    Toast.makeText(MainActivity.this,
                            "La Base de Datos ya se ha creado"+
                    "no puedes crearla nuevamente",
                            Toast.LENGTH_SHORT).show();
                }

            Toast.makeText(MainActivity.this,
                    "Base de datos: "+bd.getNombre()+
            "\nHost: "+bd.getHost()+
            "\nPuerto: "+bd.getPuerto(), Toast.LENGTH_SHORT).show();
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
