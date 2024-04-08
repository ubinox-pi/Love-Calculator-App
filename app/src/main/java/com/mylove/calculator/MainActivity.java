package com.mylove.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    //Designed and Programmed By Ayshi Shannidhya Panda & Ashish Kumar :)
    //Firebase Is Connected Just Replace Google-services.json To Your .json File In Src Folder In app folder For Application Work


    private static final long UPDATE_INTERVAL = 60000;
    FirebaseDatabase DB = FirebaseDatabase.getInstance();
    DatabaseReference loveRef = DB.getReference("love");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {

                    Random random = new Random();
                    int rno = random.nextInt(25);
                    Random(rno);

                });
            }
        }, 0, UPDATE_INTERVAL);

    Button click = findViewById(R.id.calculate);
    Button c2 = findViewById(R.id.btn_sbt);
    c2.setOnClickListener(v -> {
        TextView text1 = findViewById(R.id.Name1);
        TextView text2 = findViewById(R.id.name2);
        TextView perc = findViewById(R.id.percent_text);
        LinearLayout perce = findViewById(R.id.Percentage);
        String k = text2.getText().toString().trim();
        if (text1.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this,"Enter Your Name",Toast.LENGTH_SHORT).show();
        }
        else if (text2.getText().toString().isEmpty())
        {
            Toast.makeText(MainActivity.this,"Enter Your Crush Name",Toast.LENGTH_SHORT).show();
        }
        else if (text1.getText().toString().contains("\\s") && text1.getText().toString().contains(".*[0-9].*") && text2.getText().toString().contains(".*[0-9].*") && text2.getText().toString().contains("\\s") )
        {
            Toast.makeText(MainActivity.this,"Enter Correct Name",Toast.LENGTH_SHORT).show();
        }
        else if (text1.getText().toString().trim().equals(k))
        {
            perc.setText("99%");
            perce.setVisibility(View.VISIBLE);
        }
        else
        {
            Random random = new Random();
            int un = random.nextInt(999999999);
            String n1,n2,con;
            int l;
            float per;
            n1 = text1.getText().toString().toLowerCase().trim();
            n2 = text2.getText().toString().toLowerCase().trim();
            con = n1+n2;
            String uniqueId =con+un;
            l = con.length();
            int asciiArray;
            int sumascii = 0;
            for (int i = 0; i < l; i++) {
                char ch = con.charAt(i);
                asciiArray = (int) ch;
                sumascii = asciiArray+sumascii;
            }

            per = ((float) sumascii /(122*l))*100;
            perc.setText((int) per +"%");
            perce.setVisibility(View.VISIBLE);

            HashMap<String, String> userData = new HashMap<>();
            userData.put("name1", n1);
            userData.put("name2", n2);
            userData.put("percentagee" , String.valueOf(per));
            loveRef.child(uniqueId).setValue(userData);
        }

    });

        LinearLayout perce = findViewById(R.id.Percentage);
        perce.setOnClickListener(v -> perce.setVisibility(View.GONE));




    }




    @Override
    protected void onStart() {
        super.onStart();

        Random random = new Random();
        int rno = random.nextInt(25);
        Random(rno);

    }




    @SuppressLint("SetTextI18n")
    void Random(int a)
    {
        TextView quotes = findViewById(R.id.q);
        if(a==1)
        {
            quotes.setText("Love is patient, love is kind. It does not envy, it does not boast, it is not proud. It does not dishonor honor others, it is not self-seeking, it is not easily angered, it keeps no record of wrongs. Love does not delight in evil but rejoices with the truth. It always protects, always trusts, always hopes, always perseveres. - 1 Corinthians");
        }
        else if (a==2)
        {
            quotes.setText("To fall in love is awfully simple, but to fall out of love is simply awful. - Morris West");
        }
        else if (a==3)
        {
            quotes.setText("Where there is great love, there are always miracles. - Willa Cather");
        }
        else if (a==4)
        {
            quotes.setText("A successful marriage requires falling in love many times, always with the same person. - Mignon McLaughlin");
        }
        else if (a==5)
        {
            quotes.setText("Doubt thou the stars are fire; Doubt that the sun doth move; Doubt truth to be a liar; But never doubt I love. - William Shakespeare");
        }
        else if (a==6)
        {
            quotes.setText("We are all a little weird and life's a little weird. And when we find someone whose weirdness is compatible with ours, we join up with them and fall in mutual weirdness and call it love.- Dr. Seuss ");
        }
        else if (a==7)
        {
            quotes.setText("Absence sharpens love, presence strengthens it. - Thomas Fuller");
        }
        else if (a==8)
        {
            quotes.setText("You don't love someone because they're perfect, you love them in spite of the fact that they're not. - Jodi Picoul");
        }
        else if (a==9)
        {
            quotes.setText("The course of true love never did run smooth. - William Shakespeare ");
        }
        else if (a==10)
        {
            quotes.setText("A thousand lifetimes wouldn't be enough to show you how much I love you. - Me Before You");
        }
        else if (a==11)
        {
            quotes.setText("Love is the greatest refreshment in life. - Pablo Picasso ");
        }
        else if (a==12)
        {
            quotes.setText("As you grow older, you realize it's not the number of lovers you have had, but the number of people who have loved you truly. - Sharon Salzberg");
        }
        else if (a==13)
        {
            quotes.setText("For it was not into my ear you whispered, but into my heart. It was not my lips you kissed, but my soul. - Judy Garland");
        }
        else if (a==14)
        {
            quotes.setText("Love is friendship that has caught fire. - Ann Landers");
        }
        else if (a==15)
        {
            quotes.setText("And all at once, love has flown where it wasn't supposed to be, and that, I promise, will change everything. - The Fault in Our Stars");
        }
        else if (a==16)
        {
            quotes.setText("TI carry your heart with me wherever I go, or whatever it is I do, you are there with me. - E.E. Cummings ");
        }
        else if (a==17)
        {
            quotes.setText("They say a person needs just three things to be truly happy: something to do, someone to love, and something to hope for. - Tom Bodett ");
        }
        else if (a==18)
        {
            quotes.setText("To love and be loved is to feel the sun from both sides. - David Viscott");
        }
        else if (a==19)
        {
            quotes.setText("You're the reason for the butterflies in my stomach and the smile on my face. - Unknown ");
        }
        else if (a==20)
        {
            quotes.setText("Love is all exposure. Love is everything. - Anne Lamott");
        }
        else if (a==21)
        {
            quotes.setText("Grow old along with me! The best is yet to be. - Robert Browning");
        }
        else if (a==22)
        {
            quotes.setText("You are my sun, my moon, and all my stars. - E.E. Cummings");
        }
        else if (a==23)
        {
            quotes.setText("\"If I loved you less, I might talk about it more. - Jane Austen ");
        }
        else if (a==24)
        {
            quotes.setText("I never knew what a real smile was until I smiled at you. - Unknown");
        }
        else {

        }



    }
}