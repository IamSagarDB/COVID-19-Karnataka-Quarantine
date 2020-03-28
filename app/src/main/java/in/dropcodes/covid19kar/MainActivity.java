package in.dropcodes.covid19kar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import in.dropcodes.covid19kar.Adapter.LocationAdapter;

public class MainActivity extends AppCompatActivity implements LocationAdapter.OnClickNameListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private LocationAdapter adapter;
    private String names[] = {"Bagalkote", "Ballari", "Belagavi", "Bengaluru", "Bidar", "Chamrajanagara", "Chikkaballapura","Chikkamagaluru",
    "Dakshina Kannada","Davangere","Dharwad","Gadag","Kalaburagi","Hassan","Haveri","Kodagu","Kolar","Koppala","Mandya","Mysore","Raichur",
    "Ramanagara","Shivamogga","Tumkuru","Udupi","Uttara Kannada","Vijayapura","Yadagiri"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.main_recycler_view);
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(manager);
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        adapter = new LocationAdapter(this,names, this);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickName(int position) {
        String name = names[position];
        Intent i = new Intent(this,QuarantineActivity.class);
        i.putExtra("name",name);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_info){
            startActivity(new Intent(MainActivity.this,InfoActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
