package co.com.codesa.imctool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.com.codesa.imctool.R;
import co.com.codesa.imctool.dao.DataBase;
import co.com.codesa.imctool.models.Person;
import co.com.codesa.imctool.utils.Constants;
import co.com.codesa.imctool.utils.Utilities;

public class MyDataActivity extends AppCompatActivity implements View.OnClickListener{

    TextView mydataTvName;
    TextView mydataTvEmail;
    TextView mydataTvAge;
    TextView mydataTvGender;
    Button mydataBtnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        init();
        showData();
    }

    public void init(){
        mydataTvName = (TextView) findViewById(R.id.mydataTvName);
        mydataTvEmail = (TextView) findViewById(R.id.mydataTvEmail);
        mydataTvAge = (TextView) findViewById(R.id.mydataTvAge);
        mydataTvGender = (TextView) findViewById(R.id.mydataTvGender);
        mydataBtnLogout = (Button) findViewById(R.id.mydataBtnLogout);
        mydataBtnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.mydataBtnLogout:
                closeSession();
                break;
        }
    }

    public void showData(){
        try{
            //Obteniendo el objeto pasado desde la activity Register
            Bundle objData = getIntent().getExtras();
            if(objData!=null&&objData.containsKey("person")) {
                Person objPerson = (Person) objData.getSerializable("person");
                Log.d(Constants.TAG," objPerson >> "+objPerson.toString());
            }

            mydataTvName.setText(DataBase.objPerson.getSbName());
            mydataTvEmail.setText(DataBase.objPerson.getSbEmail());
            mydataTvAge.setText(String.valueOf(DataBase.objPerson.getNuAge()));
            mydataTvGender.setText(DataBase.objPerson.getSbSex());
        }catch(Exception e){
            Utilities.showSimpleAlertDialog(this, "Error", e.getMessage());
        }
    }

    public void closeSession(){
        //Intent intent = new Intent(this, LoginActivity.class);
        //startActivity(intent);
        finish();
    }
}
