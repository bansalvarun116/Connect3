package com.example.web.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int colour=0;
    int[] checkColour={2,2,2,2,2,2,2,2,2};
    int[][] winningpos={ {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int[] winner=new int[3];
    int win=0;


    public void oncli(View view)
    {

        ImageView imageView =(ImageView)view;
        int a=Integer.parseInt(imageView.getTag().toString());
        EditText editText1=(EditText)findViewById(R.id.editText1);
        EditText editText2=(EditText)findViewById(R.id.editText2);
        Button button=(Button)findViewById(R.id.button);


        if(checkColour[a-1]==2&&win==0) {
            imageView.setTranslationY(-1000);
            if (colour == 0) {

                imageView.setImageResource(R.drawable.red);

                checkColour[a - 1] = 0;
                colour = 1;
            } else {
                imageView.setImageResource(R.drawable.blue);

                checkColour[a - 1] = 1;
                colour = 0;

            }
            imageView.animate().translationYBy(1000).setDuration(750);
        }

        for(int j=0;j<8;j++) {

            for (int k = 0; k < 3; k++) {
                winner[k] = checkColour[winningpos[j][k]];
            }
            if (winner[0] == winner[1] && winner[1] == winner[2] && winner[0] == 1) {
                win=1;
                editText2.animate().alpha(1);
                button.animate().alpha(1);
                Toast.makeText(this,"blue has won",Toast.LENGTH_SHORT).show();

                break;
            } else if (winner[0] == winner[1] && winner[1] == winner[2] && winner[0] == 0) {
                win=1;
                editText1.animate().alpha(1);
                button.animate().alpha(1);

                Toast.makeText(this,"red has won",Toast.LENGTH_SHORT).show();
                break;
                }
        }



        }










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
