package com.babitech.videostrem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity
{
    TextInputLayout t1,t2;
    ProgressBar bar;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        check_user();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        t1=(TextInputLayout)findViewById(R.id.email);
        t2=(TextInputLayout)findViewById(R.id.pwd);
        bar=(ProgressBar)findViewById(R.id.progressBar3);


    }

    public void gotosignin(View view)
    {
        startActivity(new Intent(MainActivity.this,login.class));
    }

    public void singup(View view)
    {
        bar.setVisibility(View.VISIBLE);
        String email=t1.getEditText().getText().toString();
        String password=t2.getEditText().getText().toString();

        if(email.isEmpty()==false && password.length()>=8)
        {

            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                bar.setVisibility(View.INVISIBLE);
                                t1.getEditText().setText("");
                                t2.getEditText().setText("");
                                Toast.makeText(getApplicationContext(),"Inserted Successfully",Toast.LENGTH_LONG).show();
                            } else
                            {
                                bar.setVisibility(View.INVISIBLE);
                                t1.getEditText().setText("");
                                t2.getEditText().setText("");
                                Toast.makeText(getApplicationContext(),task.toString(),Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });

        }
        else
        {
            bar.setVisibility(View.INVISIBLE);
            Toast.makeText(getApplicationContext(),"Please input valid data",Toast.LENGTH_LONG).show();
        }

    }

    public void check_user(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            Intent intent=new Intent(this,dashboard.class);
            intent.putExtra("email",mAuth.getCurrentUser().getEmail());
            intent.putExtra("uid",mAuth.getCurrentUser().getUid());
            startActivity(intent);
        }else {

        }

    }
}