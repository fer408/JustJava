package com.example.fernando.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//  method is called when plus button is clicked
    public void increment(View view) {

        quantity = quantity +1;
        displayQuantity(quantity);

    }
//  method is called when minus button is licked
    public void decrement(View view) {

        quantity = quantity - 1;
        displayQuantity(quantity);

    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {


        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice();
        displayMessage(createOrderSummary(price,hasWhippedCream,hasChocolate));

    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {

        return quantity * 5;

    }

    public String createOrderSummary(int price, boolean whippedCream, boolean chocolate){

        String priceMessage = "Name:Fernando ";
        priceMessage = priceMessage + "\nQuantity: " +  quantity;
        priceMessage = priceMessage + "\nWhipped Cream: " + whippedCream;
        priceMessage = priceMessage +"\nChocolate: " + chocolate;
        priceMessage = priceMessage + "\nTotal: " + price;
        priceMessage = priceMessage + "\nThank you!!";
        return priceMessage;

    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int integer) {

        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + integer);

    }



    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }

}