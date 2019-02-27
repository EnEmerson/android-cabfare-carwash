# android-cabfare-carwash
CIS 4321 Android Development, Homework 2, Cabfare and Carwash App

This app lets you calculate your cab fare or how much your cash washes will be, made with Android Studio.

[Full project requirements located here.](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/HW2.docx)

---

## Main Activity

![main-activity](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/pictures/main-activity.png)

The main activity isn't very eventful, contains 2 simple onclick methods to start the other programs within the app.

```java
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

```

[Full java file here](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/java-files/MainActivity.java)

---

## Cab Fare

![cab-fare](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/pictures/cab-fare.png)

The calculate method of the cab fare app is very simple, takes in the number of miles and multiplies it by the given mileage rate.

```java
public double calculateCost(double pMiles){
        double distance = pMiles;
        double total = baseCabFee + (distance * mileageRate);
        return total;
    }

```

[Full java file here](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/java-files/CabFareActivity.java)

---

## Car Wash

![car-wash](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/pictures/car-wash.png)

The calculate method of the car wash app takes the number of washes and which car wash package is checked and spits out a total based on some numbers given prior.

```java
public double calculateWashesCost(int pWashes, String pChecked){
        int washes = pWashes;
        String washType = pChecked;

        double washPricing, tempTotal;

        switch(washType){
            case "ext":
                if(washes < 10){
                    washPricing = extWash; //10.50
                }
                else{
                    washPricing = pkgExtWash; //8.50
                }
                break;
            case "extVac":
                if(washes < 10){
                    washPricing = extWashAndVac; //15.50
                }
                else{
                    washPricing = pkgExtWashAndVac; //12.50
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
```

[Full java file here](https://github.com/EnEmerson/android-cabfare-carwash/blob/master/resources/java-files/CarWashActivity.java)