package sg.edu.rp.c346.id22015529.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etElement ;
    EditText etIndex ;
    Button btnAdd ;
    Button btnRemove ;
    Button btnUpdate ;
    ListView lvColour ;
    ArrayList<String> alColours ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour) ;
        etIndex = findViewById(R.id.editTextIndex) ;
        btnAdd = findViewById(R.id.buttonAddItem) ;
        btnRemove = findViewById(R.id.buttonRemove) ;
        btnUpdate = findViewById(R.id.buttonUpdate) ;
        lvColour = findViewById(R.id.listViewColour) ;

        alColours = new ArrayList<String>() ;

        alColours.add("Red") ;
        alColours.add("Orange") ;

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alColours) ;
        lvColour.setAdapter(adapter) ;

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString() ;
//                alColours.add(newColour) ;
                int pos = Integer.parseInt(etIndex.getText().toString()) ;
                alColours.add(pos, newColour) ;
                adapter.notifyDataSetChanged() ;
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colourClicked = alColours.get(position) ;
                Toast.makeText(MainActivity.this, colourClicked, Toast.LENGTH_SHORT).show() ; ;
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = Integer.parseInt(etIndex.getText().toString()) ;
                alColours.remove(pos) ;
                adapter.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newColour = etElement.getText().toString() ;
                int pos = Integer.parseInt(etIndex.getText().toString()) ;
                alColours.set(pos, newColour) ;
                adapter.notifyDataSetChanged();
            }
        });
    }
}