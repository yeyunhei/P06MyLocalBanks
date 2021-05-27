package sg.edu.rp.c346.id20011806.p06mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean favouriteDBS = false;
    boolean favouriteOCBC = false;
    boolean favouriteUOB = false;
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String bankChosen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0, "Website");
        menu.add(0,1,1, "Contact the Bank");
        menu.add(0,2,2,"Toggle Favourite");

        if(v == tvDBS) {
            bankChosen ="dbs";
        } else if (v == tvOCBC) {
            bankChosen ="ocbc";
        } else if (v == tvUOB) {
            bankChosen = "uob";
        }

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent i = new Intent();

        if(bankChosen.equalsIgnoreCase("dbs")) {
            if(item.getItemId() == 0) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(getString(R.string.dbsurl)));
                startActivity(i);
            } else if (item.getItemId() == 1) {
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+getString(R.string.dbsphone)));
                startActivity(i);
            } else {
                if (!favouriteDBS) {
                    favouriteDBS = true;
                    tvDBS.setTextColor(Color.RED);
                } else {
                    favouriteDBS = false;
                    tvDBS.setTextColor(Color.BLACK);
                }
            }
        } else if (bankChosen.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(getString(R.string.ocbcurl)));
                startActivity(i);
            } else if (item.getItemId() == 1){
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+getString(R.string.ocbcphone)));
                startActivity(i);
            } else {
                if (!favouriteOCBC) {
                    favouriteOCBC = true;
                    tvOCBC.setTextColor(Color.RED);
                } else {
                    favouriteOCBC = false;
                    tvOCBC.setTextColor(Color.BLACK);
                }
            }
        } else if (bankChosen.equalsIgnoreCase("uob")) {
            if(item.getItemId() == 0) {
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(getString(R.string.uoburl)));
                startActivity(i);
            } else if (item.getItemId() == 1) {
                i.setAction(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+getString(R.string.uobphone)));
                startActivity(i);
            } else {
                if (!favouriteUOB) {
                    favouriteUOB = true;
                    tvUOB.setTextColor(Color.RED);
                } else {
                    favouriteUOB = false;
                    tvUOB.setTextColor(Color.BLACK);
                }
            }
        }

        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menu for changing languages
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText(R.string.dbs);
            tvOCBC.setText(R.string.ocbc);
            tvUOB.setText(R.string.uob);
        } else {
            tvDBS.setText(R.string.dbschi);
            tvOCBC.setText(R.string.ocbcchi);
            tvUOB.setText(R.string.uobchi);
        }
        return super.onOptionsItemSelected(item);
    }
}