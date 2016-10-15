package co.com.codesa.imctool.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import co.com.codesa.imctool.R;
import co.com.codesa.imctool.dao.DataBase;
import co.com.codesa.imctool.utils.Utilities;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText loginEtEmail;
    EditText loginEtPassword;
    Button loginBtnLogin;
    Button loginBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init() {
        loginEtEmail = (EditText) findViewById(R.id.loginEtEmail);
        loginEtPassword = (EditText) findViewById(R.id.loginEtPassword);
        loginBtnLogin = (Button) findViewById(R.id.loginBtnLogin);
        loginBtnRegister = (Button) findViewById(R.id.loginBtnRegister);
        loginBtnLogin.setOnClickListener(this);
        loginBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtnLogin:
                loginPerson();
                break;
            case R.id.loginBtnRegister:
                registerPerson();
                break;
        }
    }

    public void loginPerson() {
        String sbLoginEtEmail = null;
        String sbLoginEtPassword = null;
        try {
            if (Utilities.isNotEmpty(DataBase.objPerson.getSbEmail())) {
                sbLoginEtEmail = loginEtEmail.getText().toString();
                sbLoginEtPassword = loginEtPassword.getText().toString();

                if (Utilities.isNotEmpty(sbLoginEtEmail) && Utilities.isNotEmpty(sbLoginEtPassword) && (sbLoginEtEmail.equals(DataBase.objPerson.getSbEmail()) && sbLoginEtPassword.equals(DataBase.objPerson.getSbPassword()))) {
                    Intent intent = new Intent(this, MyDataActivity.class);
                    //intent.putExtra("person", "");
                    startActivity(intent);
                } else {
                    throw new Exception("Email o clave inválidos");
                }

            } else {
                throw new Exception("No esta registrado, por favor registrese");
            }
        } catch (Exception e) {
            //Lanzar AlertDialog para mostrar error
            Utilities.showSimpleAlertDialog(this, "Error", e.getMessage());
        } finally {
            sbLoginEtEmail = null;
            sbLoginEtPassword = null;
        }
    }

    public void registerPerson() {
        Intent intent = new Intent(this, RegisterActivity.class);
        //intent.putExtra("person", "");
        startActivity(intent);
    }


}
