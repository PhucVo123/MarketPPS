package com.example.log_up;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.HtmlCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LogIn extends AppCompatActivity {
    private TextView tvForgetPwd, tvDangky;
    private Button btnSignIn;
    private EditText edPhone, edPass;
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://detaicuoiki-7b040-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        tvForgetPwd = findViewById(R.id.tvForgetPwd);
        tvDangky = findViewById(R.id.tvDangKy);
        edPhone = findViewById(R.id.ed_Phone);
        edPass = findViewById(R.id.ed_password);
        btnSignIn = findViewById(R.id.btnDangnhap);
        tvDangky.setText(HtmlCompat.fromHtml("<a href=\\\"#\\\">Đăng ký</a>",HtmlCompat.FROM_HTML_MODE_LEGACY));
        tvForgetPwd.setText(HtmlCompat.fromHtml("<a href=\\\"#\\\">Bạn quên mật khẩu?</a>",HtmlCompat.FROM_HTML_MODE_LEGACY));
        tvDangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogIn.this, LogUp.class));
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+84"+edPhone.getText().toString().trim();
                String password = edPass.getText().toString();

                if(phone.isEmpty() || password.isEmpty())
                {
                    Toast.makeText(LogIn.this, "Bạn cần nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if(snapshot.hasChild(phone))
                            {
                                final String getPassword = snapshot.child(phone).child("password").getValue(String.class);
                                final String getVerify= snapshot.child(phone).child("verify").getValue(String.class);
                                if(getPassword.equals(password) && getVerify.equals("1"))
                                {
                                    Toast.makeText(LogIn.this, "Đăn nhập thành công", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LogIn.this, MainActivity.class);
                                    intent.putExtra("phone", phone);
                                    intent.putExtra("password", password);
                                    startActivity(intent);
                                    finishAffinity();
                                }
                                else{
                                    Toast.makeText(LogIn.this, "Bạn nhập sai thông tin", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else
                            {
                                Toast.makeText(LogIn.this, "Bạn nhập sai thông tin", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
    }
}