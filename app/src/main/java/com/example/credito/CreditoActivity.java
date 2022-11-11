package com.example.credito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreditoActivity extends AppCompatActivity {

    EditText jetcodigoprestamo, jetIdentificacion;
    TextView jtvnombre, jtvprofesion, jtvsalario, jtvingresoExtra, jtvgastos, jtvvalorPrestamo;

    //Instanciar la clase de la que hereda de la clase SqliteOpenHelper
    ClsOpenHelper admin=new ClsOpenHelper(this,"Banco.bd", null,1);

    String identificacion, nombre, profesion, salario, extra, gastos, valor_prestamo, codigocredito;
    long resp;
    byte sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credito);

        getSupportActionBar().hide();
        jetcodigoprestamo=findViewById(R.id.etcodigoprestamo);
        jetIdentificacion=findViewById(R.id.etIdentificacion);
        jtvnombre=findViewById(R.id.tvnombre);
        jtvprofesion=findViewById(R.id.tvprofesion);
        jtvsalario=findViewById(R.id.tvsalario);
        jtvingresoExtra=findViewById(R.id.tvingresoExtra);
        jtvgastos=findViewById(R.id.tvgastos);
        jtvvalorPrestamo=findViewById(R.id.tvvalorPrestamo);
    }

    public void Guardar (View view){
        identificacion=jetIdentificacion.getText().toString();
        profesion=jtvprofesion.getText().toString();
        salario=jtvsalario.getText().toString();
        nombre=jtvnombre.getText().toString();
        extra=jtvingresoExtra.getText().toString();
        gastos=jtvgastos.getText().toString();
        valor_prestamo=jtvvalorPrestamo.getText().toString();
        codigocredito=jetcodigoprestamo.getText().toString();
        if (identificacion.isEmpty() || nombre.isEmpty() || profesion.isEmpty() ||
                valor_prestamo.isEmpty() || salario.isEmpty() || extra.isEmpty() || gastos.isEmpty() || codigocredito.isEmpty()){
            Toast.makeText(this, "Todos los datos son requeridos", Toast.LENGTH_SHORT).show();
            jetcodigoprestamo.requestFocus();
        }
        else{
            SQLiteDatabase fila=admin.getWritableDatabase();
            ContentValues registro=new ContentValues();
            registro.put("cod_credito",codigocredito);

        }
    }
}