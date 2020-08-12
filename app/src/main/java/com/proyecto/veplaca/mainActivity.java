package com.proyecto.veplaca;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class mainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void nextWindow (View view){
        final AlertDialog.Builder emptyAlert = new AlertDialog.Builder(this);
        if (!valueText().isEmpty()) {
            Intent intent = new Intent(this, setClass(valueText()));
            startActivity(intent);
            accept();
        }else{
            emptyAlert.setTitle("Importante");
            emptyAlert.setMessage("Ingrese ultimo digito de su placa");
            emptyAlert.setCancelable(false);
            emptyAlert.setNegativeButton("Volver", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                   emptyAlert.setCancelable(true);
                }
            });
            emptyAlert.create().show();
        }
    }



    public void accept() {
        Toast t=Toast.makeText(this,"Calendario Agosto 2020", Toast.LENGTH_LONG);
        t.show();
    }



    String valueText (){
        EditText edit = (EditText)findViewById(R.id.editTextNumber);
        return edit.getText().toString();
    }

    Class setClass (String  valueText){
        int valueInt;
        valueInt = Integer.parseInt(valueText);
        if (valueInt==1 || valueInt==2){
            return secondActivity.class;
        } else if (valueInt==3 || valueInt==4){
            return thirdActivity.class;
        } else if (valueInt==5 || valueInt==6){
            return fourthActivity.class;
        } else if (valueInt==7 || valueInt==8){
            return  fifthActivity.class;
        } else if (valueInt==9 || valueInt==0){
            return sixthActivity.class;
        }else{
            return mainActivity.class;
        }
    }



}
