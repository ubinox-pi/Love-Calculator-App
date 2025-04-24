package com.mylove.bytemechanic;

import static android.content.Intent.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Dialog d;

    private static final long UPDATE_INTERVAL = 60000;
    FirebaseDatabase DB = FirebaseDatabase.getInstance();
    DatabaseReference loveRef = DB.getReference("love");

    EditText text1;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.Name1);
        text2  = findViewById(R.id.name2);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ImageView insta = findViewById(R.id.insta);
        insta.setOnClickListener(v -> {
            Intent intent = new Intent(this, Instagram.class);
            startActivity(intent);
        });


        Timer timer = new Timer();
        timer.schedule( new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {

                    Random random = new Random();
                    int rno = random.nextInt(26);
                    Random(rno);

                });
            }
        }, 0, UPDATE_INTERVAL);

        List<String> group = Arrays.asList("kabita","ayshi", "ankit","ashish", "ashishkumar", "ramjee", "ramjeeprasad", "ashish kumar", "ramjee prasad");

    Button click = findViewById(R.id.calculate);
    Button c2 = findViewById(R.id.btn_sbt);
    c2.setOnClickListener(v -> {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(text1.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(text2.getWindowToken(), 0);
        }
        TextView perc = findViewById(R.id.percent_text);
        LinearLayout perce = findViewById(R.id.Percentage);
        String k = text2.getText().toString().trim();
        if (text1.getText().toString().isEmpty())
        {
            text1.setError("Enter Your Name");
        }
        else if (text2.getText().toString().isEmpty())
        {
            text2.setError("Enter Your Partner Name");
        }
        else if (!text1.getText().toString().matches("[a-zA-Z ]*") ||
                !text2.getText().toString().matches("[a-zA-Z ]*"))
        {
            Toast.makeText(MainActivity.this,"Enter Correct Name",Toast.LENGTH_SHORT).show();
        }
        else if (text1.getText().toString().trim().equals(k))
        {
            d = new Dialog(MainActivity.this,99);
            Show();
        }
        else if (group.contains(text1.getText().toString().toLowerCase().trim()) || group.contains(text2.getText().toString().toLowerCase().trim()))
        {
            d = new Dialog(MainActivity.this,100);
            Show();
        }
        else
        {
            try{
                Random random = new Random();
                int un = random.nextInt(999999999);
                String n1,n2,con;
                int l;
                float per;
                n1 = text1.getText().toString().toLowerCase().trim();
                n2 = text2.getText().toString().toLowerCase().trim();
                con = n1+n2;
                String uniqueId = con+un;
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
                d = new Dialog(MainActivity.this,(int) per){
                    @Override
                    public void setOnDismissListener(@Nullable OnDismissListener listener) {
                        super.setOnDismissListener(listener);
                        MainActivity.this.text1.setText("");
                        MainActivity.this.text2.setText("");
                        e1.requestFocus();
                    }

                    @Override
                    public void setOnCancelListener(@Nullable OnCancelListener listener) {
                        super.setOnCancelListener(listener);
                        MainActivity.this.text1.setText("");
                        MainActivity.this.text2.setText("");
                        e1.requestFocus();
                    }

                    @Override
                    public void setCanceledOnTouchOutside(boolean cancel) {
                        super.setCanceledOnTouchOutside(cancel);
                        MainActivity.this.text1.setText("");
                        MainActivity.this.text2.setText("");
                        e1.requestFocus();
                    }

                    @Override
                    public void setOnShowListener(@Nullable OnShowListener listener) {
                        super.setOnShowListener(listener);
                        MainActivity.this.text1.setText("");
                        MainActivity.this.text2.setText("");
                        e1.requestFocus();
                    }
                };
                Show();
                HashMap<String, String> userData = new HashMap<>();
                userData.put("name1", n1+" / ");
                userData.put("name2", n2);
                userData.put("percentage" , String.valueOf(per));
                loveRef.child(uniqueId).setValue(userData);
            } catch (Exception e) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Error");
                builder.setMessage("Something went wrong");
                builder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
                builder.create().show();
            }
        }

    });




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
            quotes.setText("If I loved you less, I might talk about it more. - Jane Austen ");
        }
        else if (a==24)
        {
            quotes.setText("I never knew what a real smile was until I smiled at you. - Unknown");
        }
        else if(a==25) {
            quotes.setText("- ByteMechanic");
        }
        else{

        }
    }

    void Show(){
        d.setCancelable(true);
        d.setContentView(R.layout.dialog);
        d.getWindow().setBackgroundDrawable(getDrawable(R.drawable.popup));
        d.getWindow().setGravity(Gravity.CENTER);
        d.dismissed( text1,  text2);
        d.create();
        d.show();
    }
    void Dismiss(){
        d.dismiss();
    }
}