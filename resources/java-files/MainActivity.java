public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button carWash = findViewById(R.id.btnCarWash);
        Button cabFare = findViewById(R.id.btnCabFare);

        carWash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CarWashActivity.class));
            }
        });

        cabFare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CabFareActivity.class));
            }
        });
    }
}
