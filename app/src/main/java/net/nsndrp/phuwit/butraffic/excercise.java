package net.nsndrp.phuwit.butraffic;

import android.content.Intent;
import android.graphics.RadialGradient;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class excercise extends AppCompatActivity {

    /* Explicit*/

    private TextView questionTextView;
    private ImageView trafficImageView;
    private RadioGroup choiceRadioGroup;
    private RadioButton choiceRadioButton1, choiceRadioButton2,
            choiceRadioButton3, choiceRadioButton4;
    private int timeAnInt = 0, intScore = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise);

        bindWidget();

        setUpChoice();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    } // main method

    private void setUpChoice() {
        String[] strMyChoice = getResources().getStringArray(R.array.times1);
        choiceRadioButton1.setText(strMyChoice[0]);
        choiceRadioButton2.setText(strMyChoice[1]);
        choiceRadioButton3.setText(strMyChoice[2]);
        choiceRadioButton4.setText(strMyChoice[3]);


    }


    public void clickAnswer(View view) {
        String[] strQuesttion = new String[5];
        strQuesttion[0] = "1. What is this?";
        strQuesttion[1] = "2. What is this?";
        strQuesttion[2] = "3. What is this?";
        strQuesttion[3] = "4. What is this?";
        strQuesttion[4] = "5. What is this?";

        int[] intImage = new int[5];
        intImage[0] = R.drawable.traffic_01;
        intImage[1] = R.drawable.traffic_02;
        intImage[2] = R.drawable.traffic_03;
        intImage[3] = R.drawable.traffic_04;
        intImage[4] = R.drawable.traffic_05;

        int[] intChoice = new int[5];
        intChoice[0] = R.array.times1;
        intChoice[1] = R.array.times2;
        intChoice[2] = R.array.times3;
        intChoice[3] = R.array.times4;
        intChoice[4] = R.array.times5;
        checkScore();
        timeAnInt += 1;

        if (timeAnInt < 5) {

            questionTextView.setText(strQuesttion[timeAnInt]);
            trafficImageView.setImageResource(intImage[timeAnInt]);
            String[] strMyChoice = getResources().getStringArray(intChoice[timeAnInt]);
            choiceRadioButton1.setText(strMyChoice[0]);
            choiceRadioButton2.setText(strMyChoice[1]);
            choiceRadioButton3.setText(strMyChoice[2]);
            choiceRadioButton4.setText(strMyChoice[3]);


        } else {
            Intent objIntent = new Intent(excercise.this, scoreActivity.class);
            objIntent.putExtra("Score", intScore);
            startActivity(objIntent);
        }

    }  //click ans

    private void checkScore() {
        final int[] intUserChoose= {1,2,4,2,4};
        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int intRadio;
                switch (checkedId) {
                    case R.id.radioButton:
                        intRadio = 1;break;
                    case R.id.radioButton2:
                        intRadio = 2;break;
                    case R.id.radioButton3:
                        intRadio = 3;break;
                    case R.id.radioButton4:
                        intRadio = 4;break;
                        default:
                            intRadio = 0;
                            break;
                }


                if (intUserChoose[timeAnInt]== checkedId) {
                    intScore ++;
                    Log.d("Test", "Score =>"+ Integer.toString(intScore));
                } else {
                }


            }//event
        });


    }


    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.textView5);
        trafficImageView = (ImageView) findViewById(R.id.imageView3);
        choiceRadioButton1 = (RadioButton) findViewById(R.id.radioButton);
        choiceRadioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        choiceRadioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        choiceRadioButton4 = (RadioButton) findViewById(R.id.radioButton4);

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "excercise Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://net.nsndrp.phuwit.butraffic/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "excercise Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://net.nsndrp.phuwit.butraffic/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}       // main class
