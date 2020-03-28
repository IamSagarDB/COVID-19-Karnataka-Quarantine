package in.dropcodes.covid19kar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import in.dropcodes.covid19kar.Adapter.QuarantineAdapter;
import in.dropcodes.covid19kar.Model.QuarantineModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class QuarantineActivity extends AppCompatActivity {
    public String name, status = "active";
    public String URL;
    public TextView mTotalSize,mNote;
    public RecyclerView recyclerView;
    public QuarantineAdapter adapter;
    public AsyncHttpClient client;
    public Workbook workbook;
    public List<QuarantineModel> quarantineModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarantine);

        recyclerView = findViewById(R.id.quarantine_recycler_view);
        mTotalSize = findViewById(R.id.quarantine_total_tv);
        mNote = findViewById(R.id.tv);
        mNote.setVisibility(View.INVISIBLE);

        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");

        quarantineModels = new ArrayList<>();

        switch (name) {
            case "Bagalkote":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Bagalkote.xls";
                break;
            case "Ballari":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Ballari.xls";
                break;
            case "Belagavi":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Belagavi.xls";
                break;
            case "Bengaluru":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Bengaluru.xls";
                break;
            case "Bidar":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Bidar.xls";
                break;
            case "Chamrajanagara":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Chamrajanagara.xls";
                break;
            case "Chikkaballapura":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Chikkaballapura.xls";
                break;
            case "Chikkamagaluru":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Chikkamagaluru.xls";
                break;

            case "Dakshina Kannada":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Dakshina%20Kannada.xls";
                break;
            case "Davangere":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Davangere.xls";
                break;
            case "Dharwad":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Dharwad.xls";
                break;
            case "Gadag":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Gadag.xls";
                break;
            case "Kalaburagi":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Kalaburagi.xls";
                break;

            case "Hassan":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Hassan.xls";
                break;

            case "Haveri":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Haveri.xls";
                break;

            case "Kodagu":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Kodagu.xls";
                break;

            case "Kolar":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Kolar.xls";
                break;

            case "Koppala":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Koppala.xls";
                break;

            case "Mandya":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Mandya.xls";
                break;

            case "Mysore":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Mysore.xls";
                break;
            case "Raichur":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Raichur.xls";
                break;
            case "Ramanagara":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Ramanagara.xls";
                break;
            case "Shivamogga":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Shivamogga.xls";
                break;

            case "Tumkuru":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Tumkuru.xls";
                break;

            case "Udupi":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Udupi.xls";
                break;

            case "Uttara Kannada":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Uttara%20Kannada.xls";
                break;

            case "Vijayapura":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Vijayapura.xls";
                break;

            case "Yadagiri":
                URL = "https://karunadu.karnataka.gov.in/hfw/kannada/homequarantivedocs/Yadagiri.xls";
                break;

        }

        getSupportActionBar().setTitle(name);

        final ProgressDialog Progress = new ProgressDialog(this);
        Progress.setMessage("Please wait...");
        Progress.setTitle("Fetching Data");
        Progress.setIcon(R.mipmap.ic_launcher);
        Progress.setCanceledOnTouchOutside(false);
        Progress.show();

        client = new AsyncHttpClient();
        client.get(URL, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(QuarantineActivity.this, "error: " + throwable.toString(), Toast.LENGTH_SHORT).show();
                Progress.hide();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {

                WorkbookSettings workbookSettings = new WorkbookSettings();
                workbookSettings.setGCDisabled(true);
                if (file != null) {
                    try {
                        workbook = workbook.getWorkbook(file);

                        Sheet sheet = workbook.getSheet(0);

                        for (int i = 1; i < sheet.getRows(); i++) {
                            Cell[] row = sheet.getRow(i);

                            getDate(row[2].getContents());
                            quarantineModels.add(new QuarantineModel(row[0].getContents(), row[1].getContents(), row[2].getContents(), row[3].getContents(), row[4].getContents(), row[5].getContents(), row[6].getContents(), row[7].getContents(), row[8].getContents(), row[9].getContents(), row[10].getContents(), row[11].getContents(), status));
                        }

                        showData();
                        mNote.setVisibility(View.VISIBLE);

                        Progress.dismiss();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Progress.hide();
                    } catch (BiffException e) {
                        e.printStackTrace();
                        Progress.hide();
                    }
                }
            }
        });
    }

    private void getDate(String q_date) {
        Format formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String current_date = formatter.format(new Date());

        if (q_date.compareTo(current_date) > 0) {
            status = "active";
        } else if (q_date.compareTo(current_date) < 0) {
            status = "inactive";
        } else if (q_date.compareTo(current_date) == 0) {
            status = "today";
        }


    }


    private void showData() {
        adapter = new QuarantineAdapter(quarantineModels, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        setTotalQuarantine();
    }

    private void setTotalQuarantine() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mTotalSize.setText("Total Quarantine in "+name+": "+String.valueOf(adapter.getItemCount()));
            }
        },500);

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

}
