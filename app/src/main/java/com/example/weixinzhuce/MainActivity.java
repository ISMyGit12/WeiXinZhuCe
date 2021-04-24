package com.example.weixinzhuce;
//190470122 渠立伟
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText account_et ;
    private EditText password_et1 ;
    private EditText password_et2 ;
    private RadioGroup sex ;
    private Button show_btn ;
    private Button clear_btn ;
    private CheckBox remember_cb ;
    private CheckBox login_cb ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始组件
        initView();
        //当显示数据按钮被点击时
        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"账户："+account_et.getText()+"\n密码："+password_et1.getText()+"\n确认密码："+password_et2.getText(),Toast.LENGTH_SHORT).show();
            }
        });
        //清楚数据
        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account_et.setText("");
                password_et1.setText("");
                password_et2.setText("");
                Toast.makeText(MainActivity.this,"数据已经被置空！",Toast.LENGTH_SHORT).show();
            }
        });
        //设置单选按钮
        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = findViewById(checkedId);
                Toast.makeText(MainActivity.this,"性别："+button.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        //监听记住用户名
        remember_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this,"开启记住用户名！",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"取消记住用户名！",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //监听自动登录
        login_cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this,"开启下次自动登录！",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"取消下次自动登录！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * 初始化组件
     */
    private void initView(){
        account_et = findViewById(R.id.account_et);
        password_et1 = findViewById(R.id.password_et1);
        password_et2 = findViewById(R.id.password_et2);
        sex = findViewById(R.id.sex);
        show_btn = findViewById(R.id.show_btn);
        clear_btn = findViewById(R.id.clear_btn);
        remember_cb = findViewById(R.id.remember_cb);
        login_cb = findViewById(R.id.login_cb);
    }

}