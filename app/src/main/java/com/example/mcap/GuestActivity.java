package com.example.mcap;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GuestActivity extends AppCompatActivity {
    TextView textJoinIP;
    TextView textMessageLog;
    EditText editGuestName;
    EditText editInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_guest);
        textJoinIP = findViewById(R.id.JoinIP);
        textMessageLog = findViewById(R.id.textGuestMessage);
        editGuestName = findViewById(R.id.editGuestName);
        editInput = findViewById(R.id.editGuestInput);
        editInput.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    String nick = editGuestName.getText().toString();
                    String message = editInput.getText().toString();
                    String log = nick + " : " + message;
                    String beforeLog = textMessageLog.getText().toString();
                    beforeLog = beforeLog + "\n " + log;
                    textMessageLog.setText(beforeLog);
                    editInput.setText("");
                }
                return false;
            }
        });
    }
}