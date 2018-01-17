package com.example.lenovo.fang_qq_login;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lenovo on 2018/1/16.
 */

public class zhuceActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText pass;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_buju);
        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login:
                String nameString = name.getText().toString().trim();
                String passString = pass.getText().toString().trim();
                SharedPreferences zhuce = getSharedPreferences("zhuce", 0);
                SharedPreferences.Editor edit = zhuce.edit();
                edit.putString("name", nameString);
                edit.putString("pass", passString);
                edit.commit();
                finish();
                break;
        }
    }

    private void submit() {
        // validate
        String nameString = name.getText().toString().trim();
        if (TextUtils.isEmpty(nameString)) {
            Toast.makeText(this, "输入账号！", Toast.LENGTH_SHORT).show();
            return;
        }

        String passString = pass.getText().toString().trim();
        if (TextUtils.isEmpty(passString)) {
            Toast.makeText(this, "输入密码！", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
