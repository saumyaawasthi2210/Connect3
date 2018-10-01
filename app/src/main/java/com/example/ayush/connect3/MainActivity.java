package com.example.ayush.connect3;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] state={0, 0, 0, 0, 0, 0, 0, 0, 0};
    int activePlayer=0;
    int flag=0,cnt=0,fall=0;
    public void onclick(View view)
    {
        if(state[0]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView1);
            a1.setImageResource(R.drawable.white);
        }

        if(state[1]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView2);
            a1.setImageResource(R.drawable.white);
        }

        if(state[2]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView3);
            a1.setImageResource(R.drawable.white);
        }

        if(state[3]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView4);
            a1.setImageResource(R.drawable.white);
        }

        if(state[4]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView5);
            a1.setImageResource(R.drawable.white);
        }

        if(state[5]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView6);
            a1.setImageResource(R.drawable.white);
        }

        if(state[6]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView7);
            a1.setImageResource(R.drawable.white);
        }

        if(state[7]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView8);
            a1.setImageResource(R.drawable.white);
        }

        if(state[8]!=0)
        {
            ImageView a1 = (ImageView) findViewById(R.id.imageView9);
            a1.setImageResource(R.drawable.white);
        }


        Button button=(Button)findViewById(R.id.button);
        button.animate().translationYBy(-1000);
        for(int i=0;i<9;i++)
        {
            state[i]=0;
        }
        activePlayer=0;
        flag=0;
        cnt=0;
        fall=0;

    }

    public void dropIn(View view)
    {
        ImageView counter = (ImageView) view;
        int tappedCounter=Integer.parseInt(counter.getTag().toString());

        if(state[tappedCounter]==0&&flag==0)
        {
            counter.setTranslationY(-1500);
            if (activePlayer == 0)
            {
                counter.setImageResource(R.drawable.red);
                state[tappedCounter]=activePlayer;
                fall++;
            }
            else
            {
                counter.setImageResource(R.drawable.yellow);
                state[tappedCounter]=activePlayer;
                fall++;
            }
            counter.animate().alpha(1);
            counter.animate().translationYBy(1500).rotation(1800).setDuration(350);

            int i;
            for(i=0;i<3;i++)
            {
                if (state[i] == state[i + 3] && state[i + 3] == state[i + 6] && state[i] != 0)
                {
                    Toast.makeText(this, "Player " + (state[i] + 1) + " is the winner!", Toast.LENGTH_SHORT).show();
                    flag=1;
                }
            }
            if(flag==0)
            {
                for(i=0;i<7;i+=3)
                    if (state[i]==state[i+1]&&state[i+1]==state[i+2]&&state[i]!=0)
                    {
                        Toast.makeText(this, "Player " + (state[i] + 1) + " is the winner!", Toast.LENGTH_SHORT).show();
                        flag=1;
                    }
            }
            if(flag==0)
            {
                if(state[0]==state[4]&&state[4]==state[8]&&state[0]!=0)
                {
                    Toast.makeText(this, "Player " + (activePlayer + 1) + " is the winner!", Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
                else
                if(state[2]==state[4]&&state[4]==state[6]&&state[2]!=2)
                {
                    Toast.makeText(this, "Player " + (activePlayer + 1) + " is the winner!", Toast.LENGTH_SHORT).show();
                    flag = 1;
                }
            }
            if(activePlayer==0)
                activePlayer=1;
            else
                activePlayer=0;
        }
        if((flag==1&&cnt==0)||(flag==0&&fall>=9&&cnt==0))
        {
            Button button= (Button) findViewById(R.id.button);
            button.animate().translationYBy(1000);
            cnt=1;
        }
        if(fall>=9&&flag==0)
        {
            Toast.makeText(this, "Game Over!! No one Wins", Toast.LENGTH_SHORT).show();
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button= (Button) findViewById(R.id.button);
        button.animate().translationYBy(-1000);
    }
}


// sec 1l bro 50 token 10