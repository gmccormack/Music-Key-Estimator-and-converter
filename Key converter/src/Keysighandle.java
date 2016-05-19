public class Keysighandle {
	
	//Author: Gerald Mccormack
	//Date: 2016
	
	//estimated key declaration
	String Estimated_key = null; 
	 
	// get key method called by the get key action listener in the mainframe
	public void getkey() {
	    
		//major Keys
		 String[] Major ={"A Major","A# Minor","B Major","C Major","C# Major"
				 ,"D Major","D# Major","E Major","F Major","F# Major","G Major","G# Major"};
		 //Minor Keys
		 String[] Minor ={"A Minor","A# Minor","B Minor","C Minor","C# Minor"
				 ,"D Minor","D# Minor","E Minor","F Minor","F# Minor","G Minor","G# Minor"};
		 
		
		 
	     // Major key profiles
	      double[] Amajor = { 
				    6.35, 2.23, 3.48,
				    2.33, 4.38, 4.09, 
				    2.52,  5.19, 2.39, 3.66, 2.29, 2.88};
	      
	      double[] Asharpmajor = { 
				    2.88, 6.35, 2.23,
				    3.48, 2.33, 4.38, 
				    4.09,  2.52, 5.19, 2.39, 3.66, 2.29};
			
	      double[] Bmajor = { 
				    2.29, 2.88, 6.35,
				    2.23, 3.48, 2.33, 
				    4.38,  4.09, 2.52, 5.19, 2.39, 3.66};
			
	      
			
	      double[] Cmajor = { 
				    3.66, 2.29, 2.88,
				    6.35, 2.23, 3.48, 
				    2.33,  4.38, 4.09, 2.52, 5.19, 2.39};
	      
	      double[] Csharpmajor = { 
				    2.39, 3.66, 2.29,
				    2.88, 6.35, 2.23, 
				    3.48,  2.33, 4.38, 4.09, 2.52, 5.19};
			
	      
	      
	      double[] Dmajor = { 
				    5.19, 2.39, 3.66,
				    2.29, 2.88, 6.35, 
				    2.23,  3.48, 2.33, 4.38, 4.09, 2.52};
	      
	      double[] Dsharpmajor = { 
				    2.52, 5.19, 2.39,
				    3.66, 2.29, 2.88, 
				    6.35,  2.23, 3.48, 2.33, 4.38, 4.09};
			
	      double[] Emajor = { 
				    4.09, 2.52, 5.19,
				    2.39, 3.66, 2.29, 
				    2.88,  6.35, 2.23, 3.48, 2.33, 4.38};
			
	      double[] Fmajor = { 
				    4.38, 4.09, 2.52,
				    5.19, 2.39, 3.66, 
				    2.29,  2.88, 6.35, 2.23, 3.48, 2.33};
	      
	     
	      double[] Fsharpmajor = { 
				    2.33, 4.38, 4.09,
				    2.52, 5.19, 2.39, 
				    3.66,  2.29, 2.88, 6.35, 2.23, 3.48};
	      
			
	      double[] Gmajor = { 
				    3.48, 2.33, 4.38,
				    4.09, 2.52, 5.19, 
				    2.39,  3.66, 2.29, 2.88, 6.35, 2.23};
			
	    
	     
			double[] Gsharpmajor = { 
				    2.23, 3.48, 2.33,
				    4.38, 4.09, 2.52, 
				    5.19,  2.39, 3.66, 2.29, 2.88, 6.35};
			
	     //minor Key profiles
	      double[] Aminor = { 
				    6.33, 2.68, 3.25,
				    5.38, 2.60, 3.53, 
				    2.54,  4.75, 3.98, 2.69, 3.34, 3.17};
	     
	      double[] Asharpminor = { 
				    3.17, 6.33, 2.68,
				    3.25, 5.38, 2.60, 
				    3.53,  2.54, 4.75, 3.98, 2.69, 3.34};
	      
	      
	      double[] Bminor = { 
				    3.34, 3.17, 6.33,
				    2.68, 3.25, 5.38, 
				    2.60,  3.53, 2.54, 4.75, 3.98, 2.69};
			
	      double[] Cminor = { 
				    2.69, 3.34, 3.17,
				    6.33, 2.68, 3.25, 
				    5.38,  2.60, 3.53, 2.54, 4.75, 3.98};
	      
	   
	      double[] Csharpminor = { 
				    3.98, 2.69, 3.34,
				    3.17, 6.33, 2.68, 
				    3.25,  5.38, 2.60, 3.53, 2.54, 4.75};
			
	      double[] Dminor = { 
				    4.75, 3.98, 2.69,
				    3.34, 3.17, 6.33, 
				    2.68,  3.25, 5.38, 2.60, 3.53, 2.54};
	      
	      double[] Dsharpminor = { 
				    2.54, 4.75, 3.98,
				    2.69, 3.34, 3.17, 
				    6.33,  2.68, 3.25, 5.38, 2.60, 3.53};
			
			
	      double[] Eminor = { 
				    3.53, 2.54, 4.75,
				    3.98, 2.69, 3.34, 
				    3.17,  6.33, 2.68, 3.25, 5.38, 2.60};
			
	      double[] Fminor = { 
				    2.60, 3.53, 2.54,
				    4.75, 3.98, 2.69, 
				    3.34,  3.17, 6.33, 2.68, 3.25, 5.38};
	      
	      double[] Fsharpminor = { 
				    5.38, 2.60, 3.53,
				    2.54, 4.75, 3.98, 
				    2.69,  3.34, 3.17, 6.33, 2.68, 3.25};
			
	      double[] Gminor = { 
				    3.25, 5.38, 2.60,
				    3.53, 2.54, 4.75, 
				    3.98,  2.69, 3.34, 3.17, 6.33, 2.68}; 
	      
	      double[] Gsharpminor = { 
				    2.68, 3.25, 5.38,
				    2.60, 3.53, 2.54, 
				    4.75,  3.98, 2.69, 3.34, 3.17, 6.33};
			
			notehandle pitch = new notehandle();
	     	// implement getting the pitch class
			pitch.note();
			//get total of each note from pitch class after it runs
	        int totalA = pitch.Total_A;
			int totalB = pitch.Total_B;
			int totalC = pitch.Total_C;
			int totalD = pitch.Total_D;
			int totalE = pitch.Total_E;
			int totalF = pitch.Total_F;
			int totalG = pitch.Total_G;
			int totalFsharp = pitch.Total_Fsharp;
			int totalAsharp = pitch.Total_Asharp;
			int totalGsharp = pitch.Total_Gsharp;
			int totalDsharp = pitch.Total_Dsharp;
			int totalCsharp = pitch.Total_Csharp;
			
			// calculate total notes
			int total = totalA + totalB + totalC + totalD + totalE 
			+ totalF + totalG + totalFsharp + totalAsharp + totalGsharp + totalDsharp + totalCsharp;
			
			//store the totals of each notes in array for correlation calculation
			double[] DurationArray = { 
				    totalA, totalAsharp, totalB,
				    totalC, totalCsharp, totalD, 
				    totalDsharp,  totalE, totalF,totalFsharp,totalG,totalGsharp};
			
			System.out.println("Number of As : " +totalA);
			System.out.println("Number of Bs : " + totalB);
			System.out.println("Number of Cs : " + totalC);
			System.out.println("Number of Ds : " + totalD);
			System.out.println("Number of Es : " + totalE);
			System.out.println("Number of F : " + totalF);
			System.out.println("Number of G : " + totalG);
			System.out.println("Number of F#s : " + totalFsharp);
			System.out.println("Number of A#s : " + totalAsharp);
			System.out.println("Number of G#s : " + totalGsharp);
			System.out.println("Number of D#s : " + totalDsharp);
			System.out.println("Number of C#s : " + totalCsharp);
			
			 CorelCo k = new CorelCo();
			 //call the calculation for each array profile
		     double coeffAmaj = k.Correlation(DurationArray, Amajor); 
		     double coeffAshmaj = k.Correlation(DurationArray, Asharpmajor); 
		     double coeffBmaj = k.Correlation(DurationArray, Bmajor); 
		     double coeffCmaj = k.Correlation(DurationArray, Cmajor); 
		     double coeffCshmaj = k.Correlation(DurationArray, Csharpmajor); 
		     double coeffDmaj = k.Correlation(DurationArray, Dmajor); 
		     double coeffDshmaj = k.Correlation(DurationArray, Dsharpmajor); 
		     double coeffEmaj = k.Correlation(DurationArray, Emajor); 
		     double coeffFmaj = k.Correlation(DurationArray, Fmajor); 
		     double coeffFshmaj = k.Correlation(DurationArray, Fsharpmajor); 
		     double coeffGmaj = k.Correlation(DurationArray, Gmajor); 
		     double coeffGshmaj = k.Correlation(DurationArray, Gsharpmajor); 
		     double coeffAmin = k.Correlation(DurationArray, Aminor); 
		     double coeffAshmin = k.Correlation(DurationArray, Asharpminor); 
		     double coeffBmin = k.Correlation(DurationArray, Bminor); 
		     double coeffCmin = k.Correlation(DurationArray, Cminor); 
		     double coeffCshmin = k.Correlation(DurationArray, Csharpminor); 
		     double coeffDmin = k.Correlation(DurationArray, Dminor); 
		     double coeffDshmin = k.Correlation(DurationArray, Dsharpminor); 
		     double coeffEmin = k.Correlation(DurationArray, Eminor); 
		     double coeffFmin = k.Correlation(DurationArray, Fminor); 
		     double coeffFshmin = k.Correlation(DurationArray, Fsharpminor); 
		     double coeffGmin = k.Correlation(DurationArray, Gminor); 
		     double coeffGshmin = k.Correlation(DurationArray, Gsharpminor); 
		     
		     System.out.println("Coefficient of a major : " + coeffAmaj);
		     System.out.println("Coefficient of a sharp major : " + coeffAshmaj);
		     System.out.println("Coefficient of b major : " + coeffBmaj);
		     System.out.println("Coefficient of c major : " + coeffCmaj);
		     System.out.println("Coefficient of c sharp major : " + coeffCshmaj);
		     System.out.println("Coefficient of d major : " + coeffDmaj);
		     System.out.println("Coefficient of d sharp major : " + coeffDshmaj);
		     System.out.println("Coefficient of e major : " + coeffEmaj);
		     System.out.println("Coefficient of f major : " + coeffFmaj);
		     System.out.println("Coefficient of f sharp major : " + coeffFshmaj);
		     System.out.println("Coefficient of g major : " + coeffGmaj);
		     System.out.println("Coefficient of g sharp major : " + coeffGshmaj);
		     System.out.println("Coefficient of a minor : " + coeffAmin);
		     System.out.println("Coefficient of a sharp minor : " + coeffAshmin);
		     System.out.println("Coefficient of b minor : " + coeffBmin);
		     System.out.println("Coefficient of c minor : " + coeffCmin);
		     System.out.println("Coefficient of c sharp minor : " + coeffCshmin);
		     System.out.println("Coefficient of d minor : " + coeffDmin);
		     System.out.println("Coefficient of d sharp minor : " + coeffDshmin);
		     System.out.println("Coefficient of e minor : " + coeffEmin);
		     System.out.println("Coefficient of f minor : " + coeffFmin);
		     System.out.println("Coefficient of f sharp minor : " + coeffFshmin);
		     System.out.println("Coefficient of g minor : " + coeffGmin);
		     System.out.println("Coefficient of g sharp minor : " + coeffGshmin);
		     
		    //compare all the resulting correlations and assign keys based on result 
		     
		     //check A Major
		     if ((coeffAmaj > coeffAshmaj) && (coeffAmaj > coeffBmaj) && (coeffAmaj > coeffCmaj) && (coeffAmaj > coeffCshmaj)
		     && (coeffAmaj > coeffDmaj) && (coeffAmaj > coeffDshmaj) && (coeffAmaj > coeffEmaj) && (coeffAmaj > coeffFmaj) &&
		     (coeffAmaj > coeffFshmaj) && (coeffAmaj > coeffGmaj)&& (coeffAmaj > coeffGshmaj)&& (coeffAmaj > coeffAmin)&& (coeffAmaj > coeffAshmin)
		     &&(coeffAmaj > coeffBmin)&&(coeffAmaj > coeffCmin)&&(coeffAmaj > coeffCshmin)&&(coeffAmaj > coeffDmin)&&(coeffAmaj > coeffDshmin)
		     &&(coeffAmaj > coeffEmin)&&(coeffAmaj > coeffFmin)&&(coeffAmaj > coeffFshmin)&&(coeffAmaj > coeffGmin)&&(coeffAmaj > coeffGshmin)
		     ) {
					
		    	 Estimated_key = Major[0];
			
		
		    	//check A# Major		
			} else if ((coeffAshmaj > coeffAmaj) && (coeffAshmaj > coeffBmaj) && (coeffAshmaj > coeffCmaj) && (coeffAshmaj > coeffCshmaj)
				     && (coeffAshmaj > coeffDmaj) && (coeffAshmaj > coeffDshmaj) && (coeffAshmaj > coeffEmaj) && (coeffAshmaj > coeffFmaj) &&
				     (coeffAshmaj > coeffFshmaj) && (coeffAshmaj > coeffGmaj)&& (coeffAshmaj > coeffGshmaj)&& (coeffAshmaj > coeffAmin)&& (coeffAshmaj > coeffAshmin)
				     &&(coeffAshmaj > coeffBmin)&&(coeffAshmaj > coeffCmin)&&(coeffAshmaj > coeffCshmin)&&(coeffAshmaj > coeffDmin)&&(coeffAshmaj > coeffDshmin)
				     &&(coeffAshmaj > coeffEmin)&&(coeffAshmaj > coeffFmin)&&(coeffAshmaj > coeffFshmin)&&(coeffAshmaj > coeffGmin)&&(coeffAshmaj > coeffGshmin)
				     ) {
		
				Estimated_key = Major[1];
				
				//check B Major
			} else if ((coeffBmaj > coeffAmaj) && (coeffBmaj > coeffAshmaj) && (coeffBmaj > coeffCmaj) && (coeffBmaj > coeffCshmaj)
					 && (coeffBmaj > coeffDmaj) && (coeffBmaj > coeffDshmaj) && (coeffBmaj > coeffEmaj) && (coeffBmaj > coeffFmaj) &&
					 (coeffBmaj > coeffFshmaj) && (coeffBmaj > coeffGmaj)&& (coeffBmaj > coeffGshmaj)&& (coeffBmaj > coeffAmin)&& (coeffBmaj > coeffAshmin)
					 &&(coeffBmaj > coeffBmin)&&(coeffBmaj > coeffCmin)&&(coeffBmaj > coeffCshmin)&&(coeffBmaj > coeffDmin)&&(coeffBmaj > coeffDshmin)
					 &&(coeffBmaj > coeffEmin)&&(coeffBmaj > coeffFmin)&&(coeffBmaj > coeffFshmin)&&(coeffBmaj > coeffGmin)&&(coeffBmaj > coeffGshmin)
					 ) {
					
			
				Estimated_key = Major[2];
		
				//check C Major
			} else if ((coeffCmaj > coeffAmaj) && (coeffCmaj > coeffBmaj) && (coeffCmaj > coeffAshmaj) && (coeffCmaj > coeffCshmaj)
					 && (coeffCmaj > coeffDmaj) && (coeffCmaj > coeffDshmaj) && (coeffCmaj > coeffEmaj) && (coeffCmaj > coeffFmaj) &&
					 (coeffCmaj > coeffFshmaj) && (coeffCmaj > coeffGmaj)&& (coeffCmaj > coeffGshmaj)&& (coeffCmaj > coeffAmin)&& (coeffCmaj > coeffAshmin)
					 &&(coeffCmaj > coeffBmin)&&(coeffCmaj > coeffCmin)&&(coeffCmaj > coeffCshmin)&&(coeffCmaj > coeffDmin)&&(coeffCmaj > coeffDshmin)
					 &&(coeffCmaj > coeffEmin)&&(coeffCmaj > coeffFmin)&&(coeffCmaj > coeffFshmin)&&(coeffCmaj > coeffGmin)&&(coeffCmaj > coeffGshmin)
					 ) {
			
				Estimated_key = Major[3];
					
				//check C# Major
			} else if ((coeffCshmaj > coeffAmaj) && (coeffCshmaj > coeffBmaj) && (coeffCshmaj > coeffCmaj) && (coeffCshmaj > coeffAshmaj)
					 && (coeffCshmaj > coeffDmaj) && (coeffCshmaj > coeffDshmaj) && (coeffCshmaj > coeffEmaj) && (coeffCshmaj > coeffFmaj) &&
					 (coeffCshmaj > coeffFshmaj) && (coeffCshmaj > coeffGmaj)&& (coeffCshmaj > coeffGshmaj)&& (coeffCshmaj > coeffAmin)&& (coeffCshmaj > coeffAshmin)
					 &&(coeffCshmaj > coeffBmin)&&(coeffCshmaj > coeffCmin)&&(coeffCshmaj > coeffCshmin)&&(coeffCshmaj > coeffDmin)&&(coeffCshmaj > coeffDshmin)
					 &&(coeffCshmaj > coeffEmin)&&(coeffCshmaj > coeffFmin)&&(coeffCshmaj > coeffFshmin)&&(coeffCshmaj > coeffGmin)&&(coeffCshmaj > coeffGshmin)
					 ) {
			
				Estimated_key = Major[4];
					
				//check D Major
			} else if ((coeffDmaj > coeffAmaj) && (coeffDmaj > coeffBmaj) && (coeffDmaj > coeffCmaj) && (coeffDmaj > coeffCshmaj)
					 && (coeffDmaj > coeffAshmaj) && (coeffDmaj > coeffDshmaj) && (coeffDmaj > coeffEmaj) && (coeffDmaj > coeffFmaj) &&
					 (coeffDmaj > coeffFshmaj) && (coeffDmaj > coeffGmaj)&& (coeffDmaj > coeffGshmaj)&& (coeffDmaj > coeffAmin)&& (coeffDmaj > coeffAshmin)
					 &&(coeffDmaj > coeffBmin)&&(coeffDmaj > coeffCmin)&&(coeffDmaj > coeffCshmin)&&(coeffDmaj > coeffDmin)&&(coeffDmaj > coeffDshmin)
					 &&(coeffDmaj > coeffEmin)&&(coeffDmaj > coeffFmin)&&(coeffDmaj > coeffFshmin)&&(coeffDmaj > coeffGmin)&&(coeffDmaj > coeffGshmin)
					 ) {
			
				Estimated_key = Major[5];
					
				//check D# Major
			} else if ((coeffDshmaj > coeffAmaj) && (coeffDshmaj > coeffBmaj) && (coeffDshmaj > coeffCmaj) && (coeffDshmaj > coeffCshmaj)
					  && (coeffDshmaj > coeffDmaj) && (coeffDshmaj > coeffAshmaj) && (coeffDshmaj > coeffEmaj) && (coeffDshmaj > coeffFmaj) &&
					  (coeffDshmaj > coeffFshmaj) && (coeffDshmaj > coeffGmaj)&& (coeffDshmaj > coeffGshmaj)&& (coeffDshmaj > coeffAmin)&& (coeffDshmaj > coeffAshmin)
					  &&(coeffDshmaj > coeffBmin)&&(coeffDshmaj > coeffCmin)&&(coeffDshmaj > coeffCshmin)&&(coeffDshmaj > coeffDmin)&&(coeffDshmaj > coeffDshmin)
					  &&(coeffDshmaj > coeffEmin)&&(coeffDshmaj > coeffFmin)&&(coeffDshmaj > coeffFshmin)&&(coeffDshmaj > coeffGmin)&&(coeffDshmaj > coeffGshmin)
					  ) {
			
				Estimated_key = Major[6];
					
				//check E Major
			} else if ((coeffEmaj > coeffAmaj) && (coeffEmaj > coeffBmaj) && (coeffEmaj > coeffCmaj) && (coeffEmaj > coeffCshmaj)
					  && (coeffEmaj > coeffDmaj) && (coeffEmaj > coeffDshmaj) && (coeffEmaj > coeffAshmaj) && (coeffEmaj > coeffFmaj) &&
					  (coeffEmaj > coeffFshmaj) && (coeffEmaj > coeffGmaj)&& (coeffEmaj > coeffGshmaj)&& (coeffEmaj > coeffAmin)&& (coeffEmaj > coeffAshmin)
					  &&(coeffEmaj > coeffBmin)&&(coeffEmaj > coeffCmin)&&(coeffEmaj > coeffCshmin)&&(coeffEmaj > coeffDmin)&&(coeffEmaj > coeffDshmin)
					  &&(coeffEmaj > coeffEmin)&&(coeffEmaj > coeffFmin)&&(coeffEmaj > coeffFshmin)&&(coeffEmaj > coeffGmin)&&(coeffEmaj > coeffGshmin)
					  ) {
			
				Estimated_key = Major[7];
					
				//check F Major
			} else if ((coeffFmaj > coeffAmaj) && (coeffFmaj > coeffBmaj) && (coeffFmaj > coeffCmaj) && (coeffFmaj > coeffCshmaj)
					  && (coeffFmaj > coeffDmaj) && (coeffFmaj > coeffDshmaj) && (coeffFmaj > coeffEmaj) && (coeffFmaj > coeffAshmaj) &&
					  (coeffFmaj > coeffFshmaj) && (coeffFmaj > coeffGmaj)&& (coeffFmaj > coeffGshmaj)&& (coeffFmaj > coeffAmin)&& (coeffFmaj > coeffAshmin)
					  &&(coeffFmaj > coeffBmin)&&(coeffFmaj > coeffCmin)&&(coeffFmaj > coeffCshmin)&&(coeffFmaj > coeffDmin)&&(coeffFmaj > coeffDshmin)
					  &&(coeffFmaj > coeffEmin)&&(coeffFmaj > coeffFmin)&&(coeffFmaj > coeffFshmin)&&(coeffFmaj > coeffGmin)&&(coeffFmaj > coeffGshmin)
					  ) {
			
				Estimated_key = Major[8];
					
				//check F# Major
			} else if ((coeffFshmaj > coeffAmaj) && (coeffFshmaj > coeffBmaj) && (coeffFshmaj > coeffCmaj) && (coeffFshmaj > coeffCshmaj)
					  && (coeffFshmaj > coeffDmaj) && (coeffFshmaj > coeffDshmaj) && (coeffFshmaj > coeffEmaj) && (coeffFshmaj > coeffFmaj) &&
					  (coeffFshmaj > coeffAshmaj) && (coeffFshmaj > coeffGmaj)&& (coeffFshmaj > coeffGshmaj)&& (coeffFshmaj > coeffAmin)&& (coeffFshmaj > coeffAshmin)
					  &&(coeffFshmaj > coeffBmin)&&(coeffFshmaj > coeffCmin)&&(coeffFshmaj > coeffCshmin)&&(coeffFshmaj > coeffDmin)&&(coeffFshmaj > coeffDshmin)
					  &&(coeffFshmaj > coeffEmin)&&(coeffFshmaj > coeffFmin)&&(coeffFshmaj > coeffFshmin)&&(coeffFshmaj > coeffGmin)&&(coeffFshmaj > coeffGshmin)
					  ) {
			
				Estimated_key = Major[9];
					
				//check G Major
			} else if ((coeffGmaj > coeffAmaj) && (coeffGmaj > coeffBmaj) && (coeffGmaj > coeffCmaj) && (coeffGmaj > coeffCshmaj)
					  && (coeffGmaj > coeffDmaj) && (coeffGmaj > coeffDshmaj) && (coeffGmaj > coeffEmaj) && (coeffGmaj > coeffFmaj) &&
					  (coeffGmaj > coeffFshmaj) && (coeffGmaj > coeffAshmaj)&& (coeffGmaj > coeffGshmaj)&& (coeffGmaj > coeffAmin)&& (coeffGmaj > coeffAshmin)
					  &&(coeffGmaj > coeffBmin)&&(coeffGmaj > coeffCmin)&&(coeffGmaj > coeffCshmin)&&(coeffGmaj > coeffDmin)&&(coeffGmaj > coeffDshmin)
					  &&(coeffGmaj > coeffEmin)&&(coeffGmaj > coeffFmin)&&(coeffGmaj > coeffFshmin)&&(coeffGmaj > coeffGmin)&&(coeffGmaj > coeffGshmin)
					  ) {
			
				Estimated_key =Major[10];
					
				//check G# Major
			} else if ((coeffGshmaj > coeffAmaj) && (coeffGshmaj > coeffBmaj) && (coeffGshmaj > coeffCmaj) && (coeffGshmaj > coeffCshmaj)
					  && (coeffGshmaj > coeffDmaj) && (coeffGshmaj > coeffDshmaj) && (coeffGshmaj > coeffEmaj) && (coeffGshmaj > coeffFmaj) &&
					  (coeffGshmaj > coeffFshmaj) && (coeffGshmaj > coeffGmaj)&& (coeffGshmaj > coeffAshmaj)&& (coeffGshmaj > coeffAmin)&& (coeffGshmaj > coeffAshmin)
					  &&(coeffGshmaj > coeffBmin)&&(coeffGshmaj > coeffCmin)&&(coeffGshmaj > coeffCshmin)&&(coeffGshmaj > coeffDmin)&&(coeffGshmaj > coeffDshmin)
					  &&(coeffGshmaj > coeffEmin)&&(coeffGshmaj > coeffFmin)&&(coeffGshmaj > coeffFshmin)&&(coeffGshmaj > coeffGmin)&&(coeffGshmaj > coeffGshmin)
					  ) {
			
				Estimated_key = Major[11];
					
				//check A Minor
			} else if ((coeffAmin > coeffAmaj) && (coeffAmin > coeffBmaj) && (coeffAmin > coeffCmaj) && (coeffAmin > coeffCshmaj)
					  && (coeffAmin > coeffDmaj) && (coeffAmin > coeffDshmaj) && (coeffAmin > coeffEmaj) && (coeffAmin > coeffFmaj) &&
					  (coeffAmin > coeffFshmaj) && (coeffAmin > coeffGmaj)&& (coeffAmin > coeffGshmaj)&& (coeffAmin > coeffAmaj)&& (coeffAmin > coeffAshmin)
					  &&(coeffAmin > coeffBmin)&&(coeffAmin > coeffCmin)&&(coeffAmin > coeffCshmin)&&(coeffAmin > coeffDmin)&&(coeffAmin > coeffDshmin)
					  &&(coeffAmin > coeffEmin)&&(coeffAmin > coeffFmin)&&(coeffAmin > coeffFshmin)&&(coeffAmin > coeffGmin)&&(coeffAmin > coeffGshmin)
					  ) {
			
				Estimated_key = Minor[0];
					
				//check A# Minor
			} else if ((coeffAshmin > coeffAmaj) && (coeffAshmin > coeffBmaj) && (coeffAshmin > coeffCmaj) && (coeffAshmin > coeffCshmaj)
					  && (coeffAshmin > coeffDmaj) && (coeffAshmin > coeffDshmaj) && (coeffAshmin > coeffEmaj) && (coeffAshmin > coeffFmaj) &&
					  (coeffAshmin > coeffFshmaj) && (coeffAshmin > coeffGmaj)&& (coeffAshmin > coeffGshmaj)&& (coeffAshmin > coeffAmin)&& (coeffAshmin > coeffAshmaj)
					  &&(coeffAshmin > coeffBmin)&&(coeffAshmin > coeffCmin)&&(coeffAshmin > coeffCshmin)&&(coeffAshmin > coeffDmin)&&(coeffAshmin > coeffDshmin)
					  &&(coeffAshmin > coeffEmin)&&(coeffAshmin > coeffFmin)&&(coeffAshmin > coeffFshmin)&&(coeffAshmin > coeffGmin)&&(coeffAshmin > coeffGshmin)
					  ) {
			
				Estimated_key = Minor[1];
					
				//check B Minor
			} else if ((coeffBmin > coeffAmaj) && (coeffBmin > coeffBmaj) && (coeffBmin > coeffCmaj) && (coeffBmin > coeffCshmaj)
					  && (coeffBmin > coeffDmaj) && (coeffBmin > coeffDshmaj) && (coeffBmin > coeffEmaj) && (coeffBmin > coeffFmaj) &&
					  (coeffBmin > coeffFshmaj) && (coeffBmin > coeffGmaj)&& (coeffBmin > coeffGshmaj)&& (coeffBmin > coeffAmin)&& (coeffBmin > coeffAshmin)
					  &&(coeffBmin > coeffAshmaj)&&(coeffBmin > coeffCmin)&&(coeffBmin > coeffCshmin)&&(coeffBmin > coeffDmin)&&(coeffBmin > coeffDshmin)
					  &&(coeffBmin > coeffEmin)&&(coeffBmin > coeffFmin)&&(coeffBmin > coeffFshmin)&&(coeffBmin > coeffGmin)&&(coeffBmin > coeffGshmin)
					  ) {
			
				Estimated_key = Minor[2];
					
				//check C Minor
			} else if ((coeffCmin > coeffAmaj) && (coeffCmin > coeffBmaj) && (coeffCmin > coeffCmaj) && (coeffCmin > coeffCshmaj)
					  && (coeffCmin > coeffDmaj) && (coeffCmin > coeffDshmaj) && (coeffCmin > coeffEmaj) && (coeffCmin > coeffFmaj) &&
					  (coeffCmin > coeffFshmaj) && (coeffCmin > coeffGmaj)&& (coeffCmin > coeffGshmaj)&& (coeffCmin > coeffAmin)&& (coeffCmin > coeffAshmin)
					  &&(coeffCmin > coeffBmin)&&(coeffCmin > coeffAshmaj)&&(coeffCmin > coeffCshmin)&&(coeffCmin > coeffDmin)&&(coeffCmin > coeffDshmin)
					  &&(coeffCmin > coeffEmin)&&(coeffCmin > coeffFmin)&&(coeffCmin > coeffFshmin)&&(coeffCmin > coeffGmin)&&(coeffCmin > coeffGshmin)
					  ) {
			
				Estimated_key = Minor[3];
					
				//check C# Minor
			} else if ((coeffCshmin > coeffAmaj) && (coeffCshmin > coeffBmaj) && (coeffCshmin > coeffCmaj) && (coeffCshmin > coeffCshmaj)
					  && (coeffCshmin > coeffDmaj) && (coeffCshmin > coeffDshmaj) && (coeffCshmin > coeffEmaj) && (coeffCshmin > coeffFmaj) &&
					  (coeffCshmin > coeffFshmaj) && (coeffCshmin > coeffGmaj)&& (coeffCshmin > coeffGshmaj)&& (coeffCshmin > coeffAmin)&& (coeffCshmin > coeffAshmin)
					  &&(coeffCshmin > coeffBmin)&&(coeffCshmin > coeffCmin)&&(coeffCshmin > coeffAshmaj)&&(coeffCshmin > coeffDmin)&&(coeffCshmin > coeffDshmin)
					  &&(coeffCshmin > coeffEmin)&&(coeffCshmin > coeffFmin)&&(coeffCshmin > coeffFshmin)&&(coeffCshmin > coeffGmin)&&(coeffCshmin > coeffGshmin)
					) {
			
				Estimated_key = Minor[4];
					
				//check D Minor 
			} else if ((coeffDmin > coeffAmaj) && (coeffDmin > coeffBmaj) && (coeffDmin > coeffCmaj) && (coeffDmin > coeffCshmaj)
					  && (coeffDmin > coeffDmaj) && (coeffDmin > coeffDshmaj) && (coeffDmin > coeffEmaj) && (coeffDmin > coeffFmaj) &&
					  (coeffDmin > coeffFshmaj) && (coeffDmin > coeffGmaj)&& (coeffDmin > coeffGshmaj)&& (coeffDmin > coeffAmin)&& (coeffDmin > coeffAshmin)
					  &&(coeffDmin > coeffBmin)&&(coeffDmin > coeffCmin)&&(coeffDmin > coeffCshmin)&&(coeffDmin > coeffAshmaj)&&(coeffDmin > coeffDshmin)
					  &&(coeffDmin > coeffEmin)&&(coeffDmin > coeffFmin)&&(coeffDmin > coeffFshmin)&&(coeffDmin > coeffGmin)&&(coeffDmin > coeffGshmin)
					) {
			
					Estimated_key = Minor[5];
					
					//check D# Minor
			} else if ((coeffDshmin > coeffAmaj) && (coeffDshmin > coeffBmaj) && (coeffDshmin > coeffCmaj) && (coeffDshmin > coeffCshmaj)
					  && (coeffDshmin > coeffDmaj) && (coeffDshmin > coeffDshmaj) && (coeffDshmin > coeffEmaj) && (coeffDshmin > coeffFmaj) &&
					  (coeffDshmin > coeffFshmaj) && (coeffDshmin > coeffGmaj)&& (coeffDshmin > coeffGshmaj)&& (coeffDshmin > coeffAmin)&& (coeffDshmin > coeffAshmin)
					  &&(coeffDshmin > coeffBmin)&&(coeffDshmin > coeffCmin)&&(coeffDshmin > coeffCshmin)&&(coeffDshmin > coeffDmin)&&(coeffDshmin > coeffAshmaj)
					  &&(coeffDshmin > coeffEmin)&&(coeffDshmin > coeffFmin)&&(coeffDshmin > coeffFshmin)&&(coeffDshmin > coeffGmin)&&(coeffDshmin > coeffGshmin)
					) {
			
					Estimated_key = Minor[6];
					
					//check E Minor
			} else if ((coeffEmin > coeffAmaj) && (coeffEmin > coeffBmaj) && (coeffEmin > coeffCmaj) && (coeffEmin > coeffCshmaj)
					  && (coeffEmin > coeffDmaj) && (coeffEmin > coeffDshmaj) && (coeffEmin > coeffEmaj) && (coeffEmin > coeffFmaj) &&
					  (coeffEmin > coeffFshmaj) && (coeffEmin > coeffGmaj)&& (coeffEmin > coeffGshmaj)&& (coeffEmin > coeffAmin)&& (coeffEmin > coeffAshmin)
					  &&(coeffEmin > coeffBmin)&&(coeffEmin > coeffCmin)&&(coeffEmin > coeffCshmin)&&(coeffEmin > coeffDmin)&&(coeffEmin > coeffDshmin)
					  &&(coeffEmin > coeffAshmaj)&&(coeffEmin > coeffFmin)&&(coeffEmin > coeffFshmin)&&(coeffEmin > coeffGmin)&&(coeffEmin > coeffGshmin)
					) {
			
					Estimated_key = Minor[7];
					
					//check F Minor
			} else if ((coeffFmin > coeffAmaj) && (coeffFmin > coeffBmaj) && (coeffFmin > coeffCmaj) && (coeffFmin > coeffCshmaj)
					  && (coeffFmin > coeffDmaj) && (coeffFmin > coeffDshmaj) && (coeffFmin > coeffEmaj) && (coeffFmin > coeffFmaj) &&
					  (coeffFmin > coeffFshmaj) && (coeffFmin > coeffGmaj)&& (coeffFmin > coeffGshmaj)&& (coeffFmin > coeffAmin)&& (coeffFmin > coeffAshmin)
					  &&(coeffFmin > coeffBmin)&&(coeffFmin > coeffCmin)&&(coeffFmin > coeffCshmin)&&(coeffFmin > coeffDmin)&&(coeffFmin > coeffDshmin)
					  &&(coeffFmin > coeffEmin)&&(coeffFmin > coeffAshmaj)&&(coeffFmin > coeffFshmin)&&(coeffFmin > coeffGmin)&&(coeffFmin > coeffGshmin)
					) {
			
					Estimated_key = Minor[8];
					
					//check F# Minor
			} else if ((coeffFshmin > coeffAmaj) && (coeffFshmin > coeffBmaj) && (coeffFshmin > coeffCmaj) && (coeffFshmin > coeffCshmaj)
					  && (coeffFshmin > coeffDmaj) && (coeffFshmin > coeffDshmaj) && (coeffFshmin > coeffEmaj) && (coeffFshmin > coeffFmaj) &&
					  (coeffFshmin > coeffFshmaj) && (coeffFshmin> coeffGmaj)&& (coeffFshmin > coeffGshmaj)&& (coeffFshmin > coeffAmin)&& (coeffFshmin > coeffAshmin)
					  &&(coeffFshmin > coeffBmin)&&(coeffFshmin > coeffCmin)&&(coeffFshmin > coeffCshmin)&&(coeffFshmin > coeffDmin)&&(coeffFshmin > coeffDshmin)
					  &&(coeffFshmin > coeffEmin)&&(coeffFshmin > coeffFmin)&&(coeffFshmin > coeffAshmaj)&&(coeffFshmin > coeffGmin)&&(coeffFshmin > coeffGshmin)
					) {
			
					Estimated_key = Minor[9];
					
					//check G Minor
			} else if ((coeffGmin > coeffAmaj) && (coeffGmin > coeffBmaj) && (coeffGmin > coeffCmaj) && (coeffGmin > coeffCshmaj)
					  && (coeffGmin > coeffDmaj) && (coeffGmin > coeffDshmaj) && (coeffGmin > coeffEmaj) && (coeffGmin > coeffFmaj) &&
					  (coeffGmin > coeffFshmaj) && (coeffGmin > coeffGmaj)&& (coeffGmin > coeffGshmaj)&& (coeffGmin > coeffAmin)&& (coeffGmin > coeffAshmin)
					  &&(coeffGmin > coeffBmin)&&(coeffGmin > coeffCmin)&&(coeffGmin > coeffCshmin)&&(coeffGmin > coeffDmin)&&(coeffGmin > coeffDshmin)
					  &&(coeffGmin > coeffEmin)&&(coeffGmin > coeffFmin)&&(coeffGmin > coeffFshmin)&&(coeffGmin > coeffAshmaj)&&(coeffGmin > coeffGshmin)
					) {
			
					Estimated_key = Minor[10];
					
					//check G# Minor
			} else if ((coeffGshmin > coeffAmaj) && (coeffGshmin > coeffBmaj) && (coeffGshmin > coeffCmaj) && (coeffGshmin > coeffCshmaj)
					  && (coeffGshmin > coeffDmaj) && (coeffGshmin > coeffDshmaj) && (coeffGshmin > coeffEmaj) && (coeffGshmin > coeffFmaj) &&
					  (coeffGshmin > coeffFshmaj) && (coeffGshmin > coeffGmaj)&& (coeffGshmin > coeffGshmaj)&& (coeffGshmin > coeffAmin)&& (coeffGshmin > coeffAshmin)
					  &&(coeffGshmin > coeffBmin)&&(coeffGshmin > coeffCmin)&&(coeffGshmin > coeffCshmin)&&(coeffGshmin > coeffDmin)&&(coeffGshmin > coeffDshmin)
					  &&(coeffGshmin > coeffEmin)&&(coeffGshmin > coeffFmin)&&(coeffGshmin > coeffFshmin)&&(coeffGshmin > coeffGmin)&&(coeffGshmin > coeffAshmin)) {
	
				    Estimated_key = Minor[11];
			
				}
		     
		     // if there are not enough notes played
			if (total < 100){
				
				Estimated_key = "Unknown";
				
			}
		     
		    System.out.println("The estimated key signature is : "+ Estimated_key);
		  
		     
	   }
	
	
	
	//return the estimated key to the mainframe for display after calling the getkey method above 
	String returnkey()
	  {
	  return Estimated_key;
	  }
		
	

}