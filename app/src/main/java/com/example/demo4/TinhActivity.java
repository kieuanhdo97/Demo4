package com.example.demo4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TinhActivity extends AppCompatActivity {

private TextView kq;
private EditText e1,e2;
private Button btAdd;
private Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tinh);
        initView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void initView() {
        kq = findViewById(R.id.kq);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        btAdd = findViewById(R.id.btAdd);

    }
    public void add(View v){
        String nn1=e1.getText().toString();
        String nn2=e2.getText().toString();
        double n1, n2;
        try{
            n1=Double.parseDouble(nn1);
            n2=Double.parseDouble(nn2);
            String kk=Tinhtoan(n1,n2,p:"+");
            kq.setText(kk);
            Toast.makeText(this,kk,Toast.LENGTH_LONG).show();

        }
        catch(NumberFormatException e){

        }
    }
    private String Tinhtoan(double x, double y, String p){
        String s="";
        switch(p){
            case"+":
                s="Tong:"+(x+y);
                break;
            case"-":
                s="Hieu:"+(x-y);
                break;
            case"*":
                s="Tich"+(x*y);
                break;
            case"/":
                if(y==0)
                    s="Khong the chia cho 0";
                else
                s="Thuong:"+(x/y);
                break;
        }
        return s;
    }

}