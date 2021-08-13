package com.example.braintrainer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public  void play(View view) {
        Intent intent = new Intent(MainActivity.this,HomeScrean.class);
        startActivity(intent);
       // button.setVisibility(view.VISIBLE);
        Toast.makeText(this, " مرحب ي زفت الطين  ", Toast.LENGTH_SHORT).show();

    }
    public void alertDialog(String name, View view)
    {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(name)
                .setMessage("مرحب ي "+name+"تريد ان تلعب؟ "  )
                .setPositiveButton(" نعم ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    play(view);
                    }
                }).setNegativeButton(" لأ ", null
        ).show();

    }

    public void abdallah(View view) {
        alertDialog("عبــدالله عبدالحميد ",view);
    }

    public void abdelrahman(View view) {
        alertDialog("عبــد الرحمن عبدالحميد",view);

    }

    public void Mohamed(View view) {
        alertDialog("محمد عبدالحميد ابو راس كبيرة ",view);

    }
}