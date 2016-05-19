import java.io.File;
import java.io.IOException;

import javax.sound.sampled.UnsupportedAudioFileException;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;

public class notehandle extends Mainframe {
	

	// total occurence of each note initialized and the note string and the pitch
	int Total_A = 0;
	int Total_B = 0;
	int Total_C = 0;
	int Total_D = 0;
	int Total_E = 0;
	int Total_F = 0;
	int Total_G = 0;
	int Total_Fsharp = 0;
	int Total_Asharp = 0;
	int Total_Gsharp = 0;
	int Total_Dsharp = 0;
	int Total_Csharp = 0;
	// String note
	String tonote = null;
	// the pitch to be converted to string
	float pitch;
	
	// method called by the key class each time a file is created
	public void note() {
		
		//get the save file path from the mainframe class
		String	saveFilePath =	Mainframe.getString();
		File f = new File(saveFilePath);
		
		// pitch detection handler convert hertz to notes and counts note occurences
		PitchDetectionHandler pdh = new PitchDetectionHandler() {
	        
			public void handlePitch(PitchDetectionResult result,AudioEvent e) {
	           
				// get resulting frequencies
	           pitch = result.getPitch();
	           //convert frequencies to string
	           tonote = String.valueOf(pitch);
	        
	           if ((pitch > 25.96) && (pitch <29.14)) {
					
					tonote ="A0";
			
				} else if ((pitch > 27.50) && (pitch <30.87)) {
			
					tonote ="A#0_or_Bb0";
		
					
				} else if ((pitch > 29.14) && (pitch <32.70)) {
		
					tonote ="B0";
		
				} else if ((pitch >  30.87) && (pitch <34.65)) {
	
					tonote ="C1";
			
				} else if ((pitch >32.70) && (pitch <36.71)) {
		
					tonote ="C#1_or_Db1";
		
			
					
				} else if ((pitch > 34.65) && (pitch <38.89)) {
		
					tonote ="D1";
	
				} else if ((pitch >36.71) && (pitch <41.20)) {
			
					tonote ="D#1_or_Eb1";

				} else if ((pitch >38.89) && (pitch <43.65)) {
		
					tonote ="E1";
	
				} else if ((pitch >41.20) && (pitch <46.25)) {
			
					tonote ="F1";

				} else if ((pitch >43.65) && (pitch <49)) {
			
					tonote ="F#1_or_Gb1";

				} else if ((pitch >46.25) && (pitch <51.91)) {
			
					tonote ="G1";

				} else if ((pitch >49) && (pitch <55)) {
		
					tonote ="G#1_or_Ab1";
	
				} else if ((pitch >51.91) && (pitch <58.27)) {
			
					tonote ="A1";
		
				} else if ((pitch >55) && (pitch <61.74)) {
		
					tonote ="A#1_or_Bb1";
		
				} else if ((pitch >58.27) && (pitch <65.41)) {
	
					tonote ="B1";
			
				} else if ((pitch > 61.74) && (pitch <69.30)) {

					tonote ="C2";
		
				} else if ((pitch >65.41) && (pitch <73.42)) {
		
					tonote ="C#2_or_Db2";
			
				} else if ((pitch >69.30) && (pitch <77.78)) {
		
					tonote ="D2";
				
				} else if ((pitch >73.42) && (pitch <82.41)) {
	
					tonote ="D#2_or_Eb2";
		
				} else if ((pitch >77.78) && (pitch <87.31)) {
	
					tonote ="E2";
		
				} else if ((pitch >82.41) && (pitch <92.50)) {
	
					tonote ="F2";
	
				} else if ((pitch >87.31) && (pitch <98)) {

					tonote ="F#2_or_Gb2";
	
				} else if ((pitch >92.50) && (pitch <103.83)) {
	
					tonote ="G2";
			
				} else if ((pitch >98) && (pitch <110)) {

					tonote ="G#2_or_Ab2";
		
				} else if ((pitch >103.83) && (pitch <116.54)) {
		
					tonote ="A2";
	
				} else if ((pitch >110) && (pitch <123.47)) {
		
					tonote ="A#2_or_Bb2";
	
				} else if ((pitch >116.54) && (pitch <130.81)) {
		
					tonote ="B2";
		
				} else if ((pitch >123.47) && (pitch <138.59)) {
	
					tonote ="C3";
	
				} else if ((pitch >130.81) && (pitch <146.83)) {
		
					tonote ="C#3_or_Db3";
		
				} else if ((pitch >138.59) && (pitch <155.56)) {
		
					tonote ="D3";
	
				} else if ((pitch >146.83) && (pitch <164.81)) {
	
					tonote ="D#3_or_Eb3";
	
				} else if ((pitch >155.56) && (pitch <174.61)) {
		
					tonote ="E3";

				} else if ((pitch >164.81) && (pitch <185)) {
		
					tonote ="F3";
	
				} else if ((pitch >174.61) && (pitch <196)) {
	
					tonote ="F#3_or_Gb3";
		
				} else if ((pitch >185) && (pitch <207.65)) {
	
					tonote ="G3";
			
				} else if ((pitch >196) && (pitch <220)) {
	
					tonote ="G#3_or_Ab3";
		
				} else if ((pitch >207.65) && (pitch <233.08)) {
	
					tonote ="A3";
	
	
				} else if ((pitch >220) && (pitch <246.94)) {
	
					tonote ="A#3_or_Bb3";
	
				} else if ((pitch >233.08) && (pitch <261.63)) {
	
					tonote ="B3";
	
				} else if ((pitch >246.94) && (pitch <277.18)) {

					tonote ="C4";
	
				} else if ((pitch >261.63) && (pitch <293.66)) {
	
					tonote ="C#4_or_Db4";
	
				} else if ((pitch >277.18) && (pitch <311.13)) {
		
					tonote ="D4";
	
				} else if ((pitch >293.66) && (pitch <329.63)) {
		
					tonote ="D#4_or_Eb4";
	
				
				} else if ((pitch >311.13) && (pitch <349.23)) {
			
					tonote ="E4";
	
				} else if ((pitch < 329.63) && (pitch <369.99)) {
		
					tonote ="F4";

				} else if ((pitch >349.23) && (pitch <392)) {
	
					tonote ="F#4_or_Gb4";

				} else if ((pitch >369.99) && (pitch <415.30)) {
		
					tonote ="G4";
	
				} else if ((pitch >392) && (pitch <440)) {
		
					tonote ="G#4_or_Ab4";
	
				} else if ((pitch >415.30) && (pitch <466.16)) {
		
					tonote ="A4";
		
				} else if ((pitch >440) && (pitch <493.88)) {
		
					tonote ="A#4_or_Bb4";
		
				} else if ((pitch >466.16) && (pitch <523.25)) {
	
					tonote ="B4";

				} else if ((pitch >493.88) && (pitch <554.37)) {
		
					tonote ="C5";
	
				} else if ((pitch >523.25) && (pitch <587.33)) {
			
					tonote ="C#5_or_Db5";
	
				} else if ((pitch >554.37) && (pitch <622.25)) {
	
					tonote ="D5";
		
				} else if ((pitch >587.33) && (pitch <695.25)) {
		
					tonote ="D#5_or_Eb5";
		
				} else if ((pitch >622.25) && (pitch <698.46)) {
			
					tonote ="E5";
	
				} else if ((pitch >659.25) && (pitch <739.99)) {
	
					tonote ="F5";
		
				} else if ((pitch >698.46) && (pitch <783.99)) {
		
					tonote ="F#5_or_Gb5";
		
				} else if ((pitch >739.99) && (pitch <830.61)) {
		
					tonote ="G5";

				} else if ((pitch >783.99) && (pitch <880)) {
	
					tonote ="G#5_or_Ab5";
		
				} else if ((pitch >830.61) && (pitch <932.33)) {
		
					tonote ="A5";
	
				} else if ((pitch >880) && (pitch <987.77)) {
		
					tonote ="A#5_or_Bb5";
	
				} else if ((pitch >932.33) && (pitch <1046.5)) {
		
					tonote ="B5";
	
				} else if ((pitch >987.77) && (pitch <1108.73)) {
	
					tonote ="C6";
	
				} else if ((pitch >1046.5) && (pitch <1174.66)) {
			
					tonote ="C#6_or_Db6";
	
				} else if ((pitch >1108.73) && (pitch <1244.51)) {
		
					tonote ="D6";
	
				} else if ((pitch >1174.66) && (pitch <1318.51)) {
	
					tonote ="D#6_or_Eb6";
	
				} else if ((pitch >1244.51) && (pitch <1396.91)) {
		
					tonote ="E6";

				} else if ((pitch >1318.51) && (pitch <1479.98)) {
		
					tonote ="F6";

				} else if ((pitch >1396.91) && (pitch <1567.98)) {
	
					tonote ="F#6_or_Gb6";
	
				} else if ((pitch >1479.98) && (pitch <1661.22)) {
	
					tonote ="G6";
	
				} else if ((pitch >1567.98) && (pitch <1760)) {
	
					tonote ="G#6_or_Ab6";

				} else if ((pitch >1661.22) && (pitch <1864.66)) {
		
					tonote ="A6";
	
				} else if ((pitch >1760) && (pitch <1975.53)) {
	
					tonote ="A#6_or_Bb6";
	
				} else if ((pitch >1864.66) && (pitch <2093)) {
	
					tonote ="B6";
	
				} else if ((pitch >1975.53) && (pitch <2217.46)) {
	
					tonote ="C7";

				} else if ((pitch >2093) && (pitch <2349.32)) {
		
					tonote ="C#7_or_Db7";

				} else if ((pitch >2217.46) && (pitch <2489.02)) {
			
					tonote ="D7";

				} else if ((pitch >2349.32) && (pitch <2637.02)) {
	
					tonote ="D#7_or_Eb7";
	
				} else if ((pitch >2489.02) && (pitch <2793.83)) {
		
					tonote ="E7";
		
				} else if ((pitch >2637.02) && (pitch <2959.96)) {
		
					tonote ="F7";
	
				} else if ((pitch >2793.83) && (pitch <3135.96)) {
	
					tonote ="F#7_or_Gb7";
	
				} else if ((pitch >2959.96) && (pitch <3322.44)) {
		
					tonote ="G7";

					
				} else if ((pitch >3135.96) && (pitch < 3520)) {
		
					tonote ="G#7_or_Ab7";

				} else if ((pitch > 3322.44) && (pitch < 3729.31)) {
	
					tonote ="A7";

				} else if ((pitch > 3520) && (pitch < 3951.07)) {
	
					tonote ="A#7_or_Bb7";
	
				} else if ((pitch > 3729.31) && (pitch < 4186.01)) {
		
					tonote ="B7";

				} else if ((pitch > 3951.07) && (pitch < 4434.92)) {
		
					tonote ="C8";
	
				} else {
					
					tonote = "";
					
		        
				}
				// count the occurence of notes for the calculation in the key handle class 
				if ((tonote == "A1") || (tonote == "A2") ||(tonote =="A3") || (tonote == "A4") ||(tonote== "A5") ||(tonote == "A6") ||(tonote== "A7") || (tonote== "A8")){
					
					Total_A++;
				
				} else if ((tonote == "B1") || (tonote == "B2") ||(tonote =="B3") || (tonote == "B4") ||(tonote== "B5") ||(tonote == "B6") ||(tonote== "B7") || (tonote== "B8")) {
					
					Total_B++;
					

				} else if ((tonote == "C1") || (tonote == "C2") ||(tonote =="C3") || (tonote == "C4") ||(tonote== "C5") ||(tonote == "C6") ||(tonote== "C7") || (tonote== "C8")) {
					
					Total_C++;

				} else if ((tonote == "D1") || (tonote == "D2") ||(tonote =="D3") || (tonote == "D4") ||(tonote== "D5") ||(tonote == "D6") ||(tonote== "D7") || (tonote== "D8")) {

					Total_D++;

				} else if ((tonote == "E1") || (tonote == "E2") ||(tonote =="E3") || (tonote == "E4") ||(tonote== "E5") ||(tonote == "E6") ||(tonote== "E7") || (tonote== "E8")) {
					
					Total_E++;

				} else if ((tonote == "F1") || (tonote == "F2") ||(tonote =="F3") || (tonote == "F4") ||(tonote== "F5") ||(tonote == "F6") ||(tonote== "F7") || (tonote== "F8")) {
					
					Total_F++;

				} else if ((tonote == "G1") || (tonote == "G2") ||(tonote =="G3") || (tonote == "G4") ||(tonote== "G5") ||(tonote == "G6") ||(tonote== "G7") || (tonote== "G8")) {
					
					Total_G++;

				} else if ((tonote == "F#1_or_Gb1") || (tonote == "F#2_or_Gb2") ||(tonote =="F#3_or_Gb3") || (tonote == "F#4_or_Gb4") ||(tonote== "F#5_or_Gb5") ||(tonote == "F#6_or_Gb6") ||(tonote== "F#7_or_Gb7") || (tonote== "F#8_or_Gb58")) {
					
					Total_Fsharp++;
					
				} else if ((tonote == "A#1_or_Bb1") || (tonote == "A#2_or_Bb2") ||(tonote =="A#3_or_Bb3") || (tonote == "A#4_or_Bb4") ||(tonote== "A#5_or_Bb5") ||(tonote == "A#6_or_Bb6") ||(tonote== "A#7_or_Bb7") || (tonote== "A#8_or_Bb8")) {
					
					Total_Asharp++;

				} else if ((tonote == "G#1_or_Ab1") || (tonote == "G#2_or_Ab2") ||(tonote =="G#3_or_Ab3") || (tonote == "G#4_or_Ab4") ||(tonote== "G#5_or_Ab5") ||(tonote == "G#6or_Ab6") ||(tonote== "G#7_or_Ab7") || (tonote== "G#8_or_Ab8")) {
					
					Total_Gsharp++;
				
				} else if ((tonote == "D#1_or_Eb1") || (tonote == "D#2_or_Eb2") ||(tonote =="D#3_or_Eb3") || (tonote == "D#4_or_Eb4") ||(tonote== "D#5_or_Eb5") ||(tonote == "D#6_or_Eb6") ||(tonote== "D#7_or_Eb7") || (tonote== "D#8_or_Eb8")) {
					
					Total_Dsharp++;

					
				} else if ((tonote == "C#1_or_Db1") || (tonote == "C#2_or_Db2") ||(tonote =="C#3_or_Db3") || (tonote == "C#4_or_Db4") ||(tonote== "C#5_or_Db5") ||(tonote == "C#6_or_Db6") ||(tonote== "C#7_or_D7") || (tonote== "C#8_or_Db8")) {
					
					Total_Csharp++;

				
				}
			
	          
	         
				
	        }
		
			
	        
		};
		// FFT implementation on the file saved at savefilepath returns the frequencies 
		AudioDispatcher dispatcher = null;
		try {
			dispatcher = AudioDispatcherFactory.fromFile(f, 1024, 0);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// audio processor method call fft sample rate and the pdh handler which converts and counts frequncies 
		AudioProcessor p = new PitchProcessor(PitchEstimationAlgorithm.FFT_YIN, 48000, 1024, pdh);
		dispatcher.addAudioProcessor(p);
		// run the dispatcher
		dispatcher.run();
		
	}
	
	
}

  