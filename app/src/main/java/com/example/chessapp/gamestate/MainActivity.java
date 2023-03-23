package com.example.chessapp.gamestate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chessapp.R;

/**
 * MainActivity
 * <p>
 * This is the main activity for the game state activity. It is responsible for
 * creating the model, view and controller, and then connecting the three. It
 * also sets the content view for the activity.
 * 
 * @author Bryce Kwon
 * @author Marshall Zhang
 * @author Christopher Yee
 * @author Magnus Graham
 * @version March 17, 2023
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}