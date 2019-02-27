public class CarWashActivity extends AppCompatActivity {

    double extWash = 10.5;
    double extWashAndVac = 15.5;
    double pkgExtWash = 8.5;
    double pkgExtWashAndVac = 12.5;
    double total;
    final DecimalFormat USD = new DecimalFormat("###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wash);

        final RadioButton exteriorOnly = findViewById(R.id.radExtOnly);
        final RadioButton extAndVacuum = findViewById(R.id.radExtVac);
        final TextView washesInput = findViewById(R.id.txtWashesInput);
        final TextView washesCostDisplay = findViewById(R.id.lblCostDisplay);
        final Button calcWashesCost = findViewById(R.id.btnCalcWash);

        calcWashesCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int numOfWashes = Integer.parseInt(washesInput.getText().toString());

                    if (numOfWashes <= 0) {
                        washesCostDisplay.setText("Please enter some number of washes, greater than 0.");
                    }
                    else if(numOfWashes < 10){
                        Toast.makeText(CarWashActivity.this, "If you order 10 or more washes, you get a 20% discount!", Toast.LENGTH_LONG).show();
                    }

                    String checkedWashType = "";

                    if(exteriorOnly.isChecked()){
                        checkedWashType = "ext";
                    }
                    else if(extAndVacuum.isChecked()){
                        checkedWashType = "extVac";
                    }

                    total = calculateWashesCost(numOfWashes, checkedWashType);
                    washesCostDisplay.setText("You have ordered " + numOfWashes + " washes which costs $" + USD.format(total));
                }
                catch(Exception exc){
                    washesCostDisplay.setText("Please enter a valid number of washes.");
                }

                washesCostDisplay.setVisibility(View.VISIBLE);
            }

        });
    }

    public double calculateWashesCost(int pWashes, String pChecked){
        int washes = pWashes;
        String washType = pChecked;

        double washPricing, tempTotal;

        switch(washType){
            case "ext":
                if(washes < 10){
                    washPricing = extWash;
                }
                else{
                    washPricing = pkgExtWash;
                }
                break;
            case "extVac":
                if(washes < 10){
                    washPricing = extWashAndVac;
                }
                else{
                    washPricing = pkgExtWashAndVac;
                }
                break;
            default:
                Toast.makeText(this, "Oopsie-doopsie, something went wrong.", Toast.LENGTH_LONG).show();
                washPricing = -1000;
                break;
        }

        tempTotal = washPricing * washes;
        return tempTotal;

    }

}
