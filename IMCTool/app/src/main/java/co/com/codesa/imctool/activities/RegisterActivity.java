package co.com.codesa.imctool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import co.com.codesa.imctool.R;
import co.com.codesa.imctool.dao.DataBase;
import co.com.codesa.imctool.utils.Utilities;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText registerEtName;
    EditText registerEtEmail;
    EditText registerEtAge;
    Spinner registerSpGender;
    EditText registerEtPassword;
    EditText registerEtPasswordConfirm;
    Button registerBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    public void init(){
        registerEtName = (EditText) findViewById(R.id.registerEtName);
        registerEtEmail = (EditText) findViewById(R.id.registerEtEmail);
        registerEtAge = (EditText) findViewById(R.id.registerEtAge);
        registerSpGender = (Spinner) findViewById(R.id.registerSpGender);
        registerEtPassword = (EditText) findViewById(R.id.registerEtPassword);
        registerEtPasswordConfirm = (EditText) findViewById(R.id.registerEtPasswordConfirm);
        registerBtnRegister = (Button) findViewById(R.id.registerBtnRegister);
        registerBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerBtnRegister:
                registerPerson();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void registerPerson(){
        try {
            boolean blValidate = true;
            String sbMessage = "";

            String sbRegisterEtName = registerEtName.getText().toString();
            String sbRegisterEtEmail = registerEtEmail.getText().toString();
            String sbRegisterEtAge = registerEtAge.getText().toString();
            int nuRegisterEtAge = 0;
            String sbRegisterSpSex = registerSpGender.getSelectedItem().toString();
            String sbRegisterEtPassword = registerEtPassword.getText().toString();
            String sbRegisterEtPasswordConfirm = registerEtPasswordConfirm.getText().toString();

            if(!Utilities.isNotEmpty(sbRegisterEtName)){
                sbMessage+="Nombre invalido\n";
                blValidate = false;
            }

            if(!Utilities.isNotEmpty(sbRegisterEtEmail)){
                sbMessage+="Email invalido\n";
                blValidate = false;
            }

            if(!Utilities.isNotEmpty(sbRegisterEtAge) && !Utilities.isNumber(sbRegisterEtAge)){
                sbMessage+="Edad invalido\n";
                blValidate = false;
            }else{
                nuRegisterEtAge = Integer.parseInt(sbRegisterEtAge);
            }

            if(!Utilities.isNotEmpty(sbRegisterEtPassword)){
                sbMessage+="Clave invalida\n";
                blValidate = false;
            }

            if(!Utilities.isNotEmpty(sbRegisterEtPasswordConfirm)){
                sbMessage+="Confirmacion de Clave invalida\n";
                blValidate = false;
            }

            if(blValidate){
                if(sbRegisterEtPassword.equals(sbRegisterEtPasswordConfirm)){
                    DataBase.objPerson.setSbName(sbRegisterEtName);
                    DataBase.objPerson.setSbEmail(sbRegisterEtEmail);
                    DataBase.objPerson.setSbSex(sbRegisterSpSex);
                    DataBase.objPerson.setNuAge(nuRegisterEtAge);
                    DataBase.objPerson.setSbPassword(sbRegisterEtPassword);

                    Intent intent =  new Intent(this, MyDataActivity.class);
                    intent.putExtra("person",DataBase.objPerson);
                    startActivity(intent);
                    finish();
                }else{
                    throw  new Exception("Clave y Confirmacion de Clave no son iguales");
                }
            }else{
                throw new Exception("Por favor complete o corrija los siguientes datos:\n"+sbMessage);
            }

        }catch (Exception e){
            Utilities.showSimpleAlertDialog(this, "Error", e.getMessage());
        }
    }
}
