package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int i=0;
    int j=5;
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view ) {
        displayPrice(i*j);
    }

    public void increment(View view) {
            incrementOrder(i++);
    }
    public void decrement(View view){
        if(i>0)
            decrementOrder(i--);
        else
            decrementOrder(0);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);

        /*
        Fizz Buzz code :p

        if(number%3==0)
            quantityTextView.setText("Fizz");
        else if(number%5==0)
            quantityTextView.setText("Buzz");
        else
            quantityTextView.setText(""+number);
            */
    }
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText("$"+number);

    }

    private void incrementOrder(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
        /*String input = quantityTextView.getText().toString();
        int quantity = Integer.parseInt(input);
        displayPrice(quantity * j);
        */
    }


    private void decrementOrder(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
        /*String input = quantityTextView.getText().toString();
        int quantity = Integer.parseInt(input);
        displayPrice(quantity * j);
        */
    }

}