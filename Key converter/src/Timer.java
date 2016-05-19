import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JLabel;
 
public class Timer extends Thread {
	
	//Code Reference
	//Title:timer
	//Author: www.codejava.net
	//Date: 2016
	//Availability: www.codejava.net
	
	// declarations
	private DateFormat dateFormater = new SimpleDateFormat("HH:mm:ss");	
	private boolean isRunning = false;
	private boolean isReset = false;
	private long startTime;
	private JLabel labelRecordTime;
	
	Timer(JLabel labelRecordTime) {
		this.labelRecordTime = labelRecordTime;
	}
	
	// run the timer
	public void run() {
		isRunning = true;
		
		startTime = System.currentTimeMillis();
		
		while (isRunning) {
			try {
				Thread.sleep(1000);
				// show timer count string
				labelRecordTime.setText("Record Time: " + toTimeString());
			} catch (InterruptedException ex) {
				ex.printStackTrace();
				if (isReset) {
					labelRecordTime.setText("Record Time: 00:00:00");
					isRunning = false;		
					break;
				}
			}
		}
	}
	
	
	// cancel the timer
	void cancel() {
		isRunning = false;		
	}
	
	// reset the count back to zero
	void reset() {
		isReset = true;
		isRunning = false;
	}
	
	// generate a string 
	private String toTimeString() {
		long now = System.currentTimeMillis();
		Date current = new Date(now - startTime);
		dateFormater.setTimeZone(TimeZone.getTimeZone("GMT"));
		String timeCounter = dateFormater.format(current);
		return timeCounter;
	}
}