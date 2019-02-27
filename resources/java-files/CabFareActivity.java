public class CabFareActivity extends AppCompatActivity {

    double baseCabFee = 3.00;
    double mileageRate = 3.25;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cab_fare);

        final TextView distanceInput = findViewById(R.id.txtMilesInput);
        final Spinner cabType = findViewById(R.id.spnCabList);
        final TextView cabCost = findViewById(R.id.lblCostDisplay);
        final Button calcCabCost = findViewById(R.id.btnCalcCabCost);

        final DecimalFormat USD = new DecimalFormat("###,##0.00");

        calcCabCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    double miles = Double.parseDouble(distanceInput.getText().toString());

                    if(miles == 0){
                        //prompt user to enter better information
                        cabCost.setText("Please enter the number of miles you will travel");
                    }
                    else{
                        double cost = calculateCost(miles);
                        String cab = (String)cabType.getSelectedItem();
                        cabCost.setText("Your trip will cost $" + USD.format(cost) + " and you'll be riding in a " + cab);
                    }
                }
                catch(Exception exc){
                    cabCost.setText("Please enter the number of miles you will travel");
                }
            }
        });
    }

    public double calculateCost(double pMiles){
        double distance = pMiles;
        double total = baseCabFee + (distance * mileageRate);
        return total;
    }
}