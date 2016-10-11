package id.sch.smktelkom_mlg.learn.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;

public class ActivityInput extends AppCompatActivity {

    public static final String NAMA = "Nama";
    public static final String TAHUN_LAHIR = "TahunLahir";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_input);

        findViewById(R.id.buttonFinish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etNama = (EditText) findViewById(R.id.editTextNama);
                EditText etThnLhir = (EditText) findViewById(R.id.editTextThnLhir);

                String nama = etNama.getText().toString();
                String thnLhstr = etThnLhir.getText().toString();

                int thnLhr = thnLhstr.isEmpty() ?
                        Calendar.getInstance().get(Calendar.YEAR) :
                        Integer.parseInt(thnLhstr);

                Intent intent = new Intent();
                intent.putExtra(NAMA, nama);
                intent.putExtra(TAHUN_LAHIR, thnLhr);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
