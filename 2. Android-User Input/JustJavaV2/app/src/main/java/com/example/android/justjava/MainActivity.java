package com.example.android.justjava;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
    int i=0;  // variable price
    static int j=5;  //fixed price
    static int topping_chocolate=2;
    static int topping_cream=1;

    private String getEditText(){
        EditText ed=(EditText) findViewById(R.id.editText);
        String currentText=ed.getText().toString();
        return currentText;
    }

    private String getWhippedChecked(){
        CheckBox ck=(CheckBox) findViewById(R.id.checkBox);
        if(ck.isChecked())
          return "true";
        else return "false";
    }

    private String getChocolateChecked(){
        CheckBox ck=(CheckBox) findViewById(R.id.checkBox2);
        if(ck.isChecked())return "true";
        else return "false";
    }

    public void submitOrder(View view ) {
        displayOrderSummary();
    }
    public void submitMailIntent(View view){openMailIntent();}

    public void increment(View view) {
            incrementOrder(++i);
    }
    public void decrement(View view){
        if(i>0)
            decrementOrder(--i);
        else
            decrementOrder(0);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+(i*j));

    }

    private int getQuantity(){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        int quantity=Integer.parseInt(quantityTextView.getText().toString());
        return quantity;
    }

    private int getProductSum(){

        CheckBox ck1=(CheckBox) findViewById(R.id.checkBox);
        CheckBox ck2=(CheckBox) findViewById(R.id.checkBox2);

        if(ck1.isChecked() && ck2.isChecked()){
            return ((j+topping_chocolate+topping_cream)*getQuantity());
        }

        else if(ck1.isChecked() && !ck2.isChecked()){
            return ((j+topping_cream)*getQuantity());
        }

        else if(!ck1.isChecked() && ck2.isChecked()){
            return ((j+topping_chocolate)*getQuantity());
        }

        else return 0;
    }

    private void displayOrderSummary(){
        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_view);
        orderSummaryView.setText("Name: "+getEditText()+"\n"+"Added Whipped Cream: "+getWhippedChecked()+"\n"+"Added Chocolate: "+getChocolateChecked()+"\n"+"Quantity: "+getQuantity()+"\n"+"Total: $"+getProductSum()+"\n"+"Thank you!");
    }


    private void incrementOrder(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    private void decrementOrder(int number){
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(""+number);
    }

    private void openMailIntent(){
        TextView orderSummaryView = (TextView) findViewById(R.id.order_summary_view);
        String xyz=orderSummaryView.getText().toString();

        /*  allows user to choose appropriate app to launch the intent
        Intent email = new Intent(Intent.ACTION_SENDTO);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ckshhh9696@gmail.com"});
        email.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
        email.putExtra(Intent.EXTRA_TEXT, xyz);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose an Email client :"));
        */

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "ckshhh9696@gmail.com"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Order Summary");
        emailIntent.putExtra(Intent.EXTRA_TEXT, xyz);
        startActivity(Intent.createChooser(emailIntent, "Chooser Title"));


    }

}