package stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pageObjects.DeliveryPageObjects;

public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMMM-yyyy");
		String[] expectedDate = formatter.format(date).split("-");
		for(String i:expectedDate){
			System.out.println(i);
			
			
			
		}
		
		String test ="Delivery on a date of your choice, available 7 days a week 7.30am - 6pm (excluding public holidays). Order by 8pm for delivery following day. Other exclusions may apply.";
		
		String actual = test.substring(59, 71);
		System.out.println(actual);
		//String[] actualDate = deliveryDate.getText().toString().split(" ");
		
	}

}
