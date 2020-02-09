package edu.miracosta.cs134.jmoebius;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.jmoebius.model.ShipItem;

/**
 * Main Activity for Shipping Calculator app.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Instance variables to bridge View/Model. ShipItem will hold all information for calculating
     * shipping costs. EditText handles user input for weight of item shipping. TextViews show the
     * base cost to ship an item, the added cost of weight over 16 oz, and the total cost to ship.
     */
    private ShipItem currentShipItem;
    private EditText weightEditText;
    private TextView baseCostText;
    private TextView addedCostText;
    private TextView totalShippingCostText;

    // Instance vairable to format output (currency)
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());

    /**
     * Makes the default view visible to show the shipping information to the user and where they
     * can input the weight of the item.
     *
     * @param savedInstanceState         Bundle object containing the activity's previously saved
     *                                   state. If the activity has never existed before, the value
     *                                   of the Bundle object is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wire up instance variables
        currentShipItem = new ShipItem();
        weightEditText = findViewById(R.id.weightEditText);
        baseCostText = findViewById(R.id.baseCostText);
        addedCostText = findViewById(R.id.addedCostText);
        totalShippingCostText = findViewById(R.id.totalShippingCostText);

        // Implement interface for EditText. Calculates and changes the TextView shipping cost info
        // when the user inputs the item weight.
        weightEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // Read input from EditText and store in currentShipItem (Model)
                try {
                    double weight = Double.parseDouble(weightEditText.getText().toString());
                    currentShipItem.setWeight(weight);
                } catch (NumberFormatException e) {
                    currentShipItem.setWeight(0.0);
                }
                calculateShippingCost();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * Updates TextViews to display most current shipping cost info.
     */
    public void calculateShippingCost() {
        baseCostText.setText(currency.format(currentShipItem.getBaseCost()));
        addedCostText.setText(currency.format(currentShipItem.getAddedCost()));
        totalShippingCostText.setText(currency.format(currentShipItem.getTotalShippingCost()));
    }
}
