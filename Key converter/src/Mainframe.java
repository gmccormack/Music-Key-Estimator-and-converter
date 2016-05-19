import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.WaveformSimilarityBasedOverlapAdd;
import be.tarsos.dsp.WaveformSimilarityBasedOverlapAdd.Parameters;
import be.tarsos.dsp.io.TarsosDSPAudioFormat;
import be.tarsos.dsp.io.jvm.AudioDispatcherFactory;
import be.tarsos.dsp.io.jvm.AudioPlayer;
import be.tarsos.dsp.io.jvm.JVMAudioInputStream;
import be.tarsos.dsp.io.jvm.WaveformWriter;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
import be.tarsos.dsp.resample.RateTransposer;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.awt.Color;


public class Mainframe extends JFrame implements ActionListener {
	

	//Author: Gerald Mccormack
	//Date: 2016


	//variable declarations
	private WaveformSimilarityBasedOverlapAdd wsola;
	AudioDispatcher dispatcher;
	private AudioPlayer audioPlayer;
	private RateTransposer rateTransposer;
	private double currentFactor;// pitch shift factor
	private double sampleRate;
	private final JCheckBox originalTempoCheckBox;
	private final JSpinner centsSpinner;
	JButton buttonplaykchange = new JButton("Play/Save File");
	JButton Keyup = new JButton("Key up");
	JButton getKey = new JButton("Get Key");
	JButton Keydown = new JButton("Key down");
	JButton RecordButton = new JButton("Record");
    JButton buttonPlay = new JButton("Play back");
	JLabel labelRecordTime = new JLabel("Timer: 00:00:00");
    JavaSoundRecorder recorder = new JavaSoundRecorder();
    Playwav player = new Playwav();
    Thread playbackThread;
    Timer timer;
    boolean isRecording = false;
    boolean isPlaying = false; 
    //labels
    public JLabel header = new JLabel("Music Key Converter");
    public JLabel keysig = new JLabel("Key signature");
    public JLabel step1 = new JLabel("Step1. Record Tune >>");
    public JLabel step2 = new JLabel("Step2. Listen to playback>>");
    public JLabel step3 = new JLabel("Step3. Calculate Key>>");
    public JLabel step4 = new JLabel("Step4. Move Key up or down semitone>>");
    public JLabel step5 = new JLabel("<html>Step5. Listen to and write<br> Key change to file>></html>");
	public static String saveFilePath = null; 
	// count key change
	String[] increment ={"-11","-10","-9","-8","-7","-6","-5","-4","-3","-2","-1","0","+1","+2","+3","+4"
			 ,"+5","+6","+7","+8","+9","+10","+11"};
	// set to 0
	int index = 11;
	String current = increment[index];
	JLabel keyincrem = new JLabel();
	//icons
	private ImageIcon iconRecord = new ImageIcon(getClass().getResource("Record.gif"));
	private ImageIcon iconStop = new ImageIcon(getClass().getResource("Stop.gif"));
	private ImageIcon iconPlay = new ImageIcon(getClass().getResource("Play.gif"));
	private ImageIcon iconUp = new ImageIcon(getClass().getResource("uparrow.png"));
	private ImageIcon iconDown = new ImageIcon(getClass().getResource("downarrow.png"));
	
	
	// change listener for moving key and time
	private ChangeListener parameterSettingChangedListener = new ChangeListener(){
		@Override
				public void stateChanged(ChangeEvent arg0) {
					if (arg0.getSource() instanceof JSpinner) {
						 int centValue = Integer.valueOf(((JSpinner) arg0.getSource())
								.getValue().toString());
						 currentFactor = centsToFactor(centValue);
					}
					
					
					if (Mainframe.this.dispatcher != null) {
						// check if the original tempo is kept or not
						 if(originalTempoCheckBox.getModel().isSelected()){
							 wsola.setParameters(WaveformSimilarityBasedOverlapAdd.Parameters.musicDefaults(currentFactor, sampleRate));
						 } else {
							 wsola.setParameters(WaveformSimilarityBasedOverlapAdd.Parameters.musicDefaults(1, sampleRate));
						 }
						 rateTransposer.setFactor(currentFactor);
					 }
				}}; 

	// constructor set up graphical user interface
	public Mainframe() {
		
		// layout set up
		ContentPanel contentPanel = new ContentPanel();
	    getContentPane().add(contentPanel);
	    contentPanel.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Key Converter");
		setBounds(200, 10, 950, 700);
		Color white = new Color(255,255,255);
		TitledBorder titledBorder = BorderFactory.createTitledBorder("Welcome");
		titledBorder.setTitleColor(white);
		contentPanel.setBorder(titledBorder);
		currentFactor = 1;
		
		//positions and attributes
		header.setFont(new Font("Arial", Font.BOLD, 29));
		header.setForeground(Color.white);
		header.setBounds(320, 20, 400, 32);
		contentPanel.add(header);
		
		step1.setFont(new Font("Arial", Font.PLAIN, 20));
		step1.setForeground(Color.white);
		step1.setBounds(10, 88, 400, 27);
		contentPanel.add(step1);
		
		step2.setFont(new Font("Arial", Font.PLAIN, 20));
		step2.setForeground(Color.white);
		step2.setBounds(10, 200, 400, 27);
		contentPanel.add(step2);
		
		step3.setFont(new Font("Arial", Font.PLAIN, 20));
		step3.setForeground(Color.white);
		step3.setBounds(10, 330, 600, 27);
		contentPanel.add(step3);
		
		step4.setFont(new Font("Arial", Font.PLAIN, 20));
		step4.setForeground(Color.white);
		step4.setBounds(10, 450, 450, 27);
		contentPanel.add(step4);
		
		step5.setFont(new Font("Arial", Font.PLAIN, 20));
		step5.setForeground(Color.white);
		step5.setBounds(10, 500, 400, 200);
		contentPanel.add(step5);
		
		
		keyincrem.setFont(new Font("Arial", Font.PLAIN, 23));
		keyincrem.setForeground(Color.white);
		keyincrem.setBounds(595, 450, 100, 27);
		keyincrem.setText( current);
		contentPanel.add(keyincrem);
	
		buttonplaykchange.setFont(new Font("Tahoma", Font.PLAIN, 18));
		buttonplaykchange.setBounds(350, 600, 220, 23);
		buttonplaykchange.setIcon(iconPlay);
		buttonplaykchange.setEnabled(false);
	    contentPanel.add(buttonplaykchange);
	    
	    
	    originalTempoCheckBox = new JCheckBox("Keep original tempo?", true);
		originalTempoCheckBox.setBounds(600, 600, 211, 23);
		contentPanel.add(originalTempoCheckBox);
		originalTempoCheckBox.setBackground(SystemColor.inactiveCaption);
				
	    
	    Keydown.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    Keydown.setBounds(410, 450, 160, 25);
	    Keydown.setIcon(iconDown);
	    Keydown.setEnabled(false);
	    contentPanel.add(Keydown);
	    
	    Keyup.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    Keyup.setBounds(650, 450, 130, 25);
	    Keyup.setIcon(iconUp);
	    Keyup.setEnabled(false);
	    contentPanel.add(Keyup);
	    
	    getKey.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    getKey.setBounds(600, 330, 200, 23);
	    getKey.setIcon(iconUp);
	    getKey.setEnabled(false);
	    contentPanel.add( getKey);
	    
	    RecordButton.setFont(new Font("Arial", Font.PLAIN, 18));
	    RecordButton.setIcon(iconRecord);
	    RecordButton.setBounds(270, 88, 200, 23);
	    contentPanel.add(RecordButton);
	    
	    buttonPlay.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    buttonPlay.setBounds(270, 200, 205, 25);
	    buttonPlay.setIcon(iconPlay);
	    buttonPlay.setEnabled(false);
	    contentPanel.add(buttonPlay);
	  
	   
	    labelRecordTime.setFont(new Font("Arial", Font.PLAIN, 22));
	    labelRecordTime.setForeground(Color.white);
	    labelRecordTime.setBounds(550, 80, 400, 40);
	    contentPanel.add(labelRecordTime);
	    
	
	    keysig.setFont(new Font("Arial", Font.PLAIN, 27));
	    keysig.setForeground(Color.white);
	    keysig.setBounds(270, 330, 400, 27);
	    contentPanel.add(keysig);
	  
		centsSpinner = new JSpinner();
		centsSpinner.setBounds(790, 630, 138, 23);
		centsSpinner.setEditor(new JSpinner.DefaultEditor(centsSpinner));
		centsSpinner.addChangeListener(parameterSettingChangedListener);
		
		originalTempoCheckBox.addChangeListener(parameterSettingChangedListener);
		
		// start play back of changed key and change buttons accordingly
		
		buttonplaykchange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					 File f = new File(saveFilePath);
					 buttonplaykchange.setEnabled(false);
					 playKeyChange(f,null);
					 stopPlaying();
  					 buttonPlay.setEnabled(false);
  					 Keyup.setEnabled(false);
  					 Keydown.setEnabled(false);
  					JOptionPane.showMessageDialog(Mainframe.this,
  							"Pleas allow play back to finish to write changes to file. When finished press record to start again");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			
				
			}
			
			
		});
	    
		// action listener to move key up one semi tone and set the key to current
	    Keyup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				buttonplaykchange.setEnabled(true);
				int value = (Integer) centsSpinner.getValue();
				if(value < 1100){
				value = value + 100;
				centsSpinner.setValue(value);
				index++;
				current =  increment[index];
				keyincrem.setText(current);
				}
				
			}
		});
	   
	   
	    // call the implementation of the key finding algorithm and return result
	    getKey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Keysighandle k = new Keysighandle();
				//call the get key method and implement the algorithm
				k.getkey();
				String key = k.returnkey();
				// display the key on the screen
				keysig.setText("Estimated Key:  "+key);
				// check if key returned unknown if it did display message 
				if (key == "Unknown" ){
					JOptionPane.showMessageDialog(Mainframe.this,
  							"Please provide enough notes to be able to identify a key");
				}
				// set the button to false after calculation
				getKey.setEnabled(false);
				
			}
		});
	    
	    // move the key down one semi-tone and set it to current
	    Keydown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				buttonplaykchange.setEnabled(true);
				int value = (Integer) centsSpinner.getValue();
				if(value >- 1100){
				value = value - 100;
				centsSpinner.setValue(value);
				index--;
				current =  increment[index];
				keyincrem.setText(current);
				
				
				}
				
				
			}
		});
	    
	    
	    
	    
	    // Record button action listener to start and stop recording
	    RecordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!isRecording) {
					startRecording();
				} else {
					stopRecording();
					
				}
				
				
			}
		});
	    
	    // action listener to play or stop the wav file
	    buttonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (!isPlaying) {
					playBack();

				   
				} else {
					stopPlaying();
				}
				
				
			}
		});
	    
	    
	
	    
	}
	
	// start recording function starts recording  thread
	private void startRecording() {
		Thread recordThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					
					try {
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					// if key change play back is playing stop it because recording gets priority
					if(dispatcher != null){
						dispatcher.stop();
					}
					keysig.setText("Estimated Key");
					buttonPlay.setEnabled(false);
					isRecording = true;
					RecordButton.setIcon(iconStop);
					RecordButton.setText("Stop");
					RecordButton.setEnabled(true);
					Keyup.setEnabled(false);
					Keydown.setEnabled(false);
					buttonplaykchange.setEnabled(false);
					getKey.setEnabled(false);
					recorder.start();
					
					
					
				} catch (LineUnavailableException ex) {
					JOptionPane.showMessageDialog(Mainframe.this,
							"Error", "Could not start recording sound!",
							JOptionPane.ERROR_MESSAGE);
					ex.printStackTrace();
				}
			}
		});
		
		//start recoding and timer
		recordThread.start();
		timer = new Timer(labelRecordTime);
		timer.start();
	
		
	}
	
	// play key change method that play back the key change and writes it to the file 
	public void playKeyChange(File inputFile,Mixer mixer){
		if(dispatcher != null){
			dispatcher.stop();
		}
		final AudioFormat format;
		try {
			if(inputFile != null){
				format = AudioSystem.getAudioFileFormat(inputFile).getFormat();
			}else{
				format = new AudioFormat(44100, 16, 1, true,true);
			}
			// resample to current factor rate 
			rateTransposer = new RateTransposer(currentFactor);
			audioPlayer = new AudioPlayer(format);
			sampleRate = format.getSampleRate();
			// check if the keep original speed is checked
			 if(originalTempoCheckBox.getModel().isSelected() && inputFile != null){
				 // scale back to original time
				 wsola = new WaveformSimilarityBasedOverlapAdd(Parameters.musicDefaults(currentFactor, sampleRate));
			 } else {// keeps sample rate the same
				 wsola = new WaveformSimilarityBasedOverlapAdd(Parameters.musicDefaults(1, sampleRate));
			 }
			 
			 // run the dispatcher
			dispatcher = AudioDispatcherFactory.fromFile(inputFile,wsola.getInputBufferSize(),wsola.getOverlap());
			wsola.setDispatcher(dispatcher);
			dispatcher.addAudioProcessor(wsola);
	    	dispatcher.addAudioProcessor(rateTransposer);
	    	dispatcher.addAudioProcessor(audioPlayer);
			Thread t = new Thread(dispatcher);
			t.start();
			dispatcher.getFormat();
			// write change to wav file
			WaveformWriter wfw = new WaveformWriter(format,saveFilePath);
			dispatcher.addAudioProcessor(wfw);
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	//stop the recording and timer and call the save file method 
	private void stopRecording() {
		isRecording = false;
		try {
			timer.cancel();
			RecordButton.setText("Record");
			RecordButton.setIcon(iconRecord);
			recorder.stop();
			saveFile();
			

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(Mainframe.this, "Error",
					"Error stopping sound recording!",
					JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	// play back recording method 
	private void playBack() {
		timer = new Timer(labelRecordTime);
		timer.start();
		isPlaying = true;
		playbackThread = new Thread(new Runnable() {

			@Override
			public void run() {
				try {

					buttonPlay.setText("Stop");
					buttonPlay.setIcon(iconStop);
					RecordButton.setEnabled(false);
					player.play(saveFilePath);
					timer.reset();
					buttonPlay.setText("Play back");
					buttonPlay.setIcon(iconPlay);
					isPlaying = false;
					RecordButton.setEnabled(true);

				} catch (UnsupportedAudioFileException ex) {
					ex.printStackTrace();
				} catch (LineUnavailableException ex) {
					ex.printStackTrace();
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			}
		});

		playbackThread.start();
	}
	
	// stop playing back reset timer 
	private void stopPlaying() {
		timer.reset();
		timer.interrupt();
		player.stop();
		playbackThread.interrupt();
		buttonPlay.setIcon(iconPlay);
	}
	
	// convert the cent to factor method for factor rate to move up key 
	public static double centsToFactor(double cent){
		return 1 / Math.pow(Math.E,cent*Math.log(2)/1200/Math.log(Math.E)); 
	}
	
	
	//	Getter called by the notehandle class to get the save file path
	public	static	String	getString()
	{
		return	saveFilePath;
	}

	
	// save file method uses file chooser for user to choose location and file name
	private void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		FileFilter wavFilter = new FileFilter() {
			@Override
			public String getDescription() {
				return "Sound file (*.WAV)";
			}
			
			// make the file a wav file 
			@Override
			public boolean accept(File file) {
				if (file.isDirectory()) {
					return true;
				} else {
					return file.getName().toLowerCase().endsWith(".wav");
				}
			}
		};

		fileChooser.setFileFilter(wavFilter);
		fileChooser.setAcceptAllFileFilterUsed(false);
		
		// get the users path
		int userChoice = fileChooser.showSaveDialog(this);
		if (userChoice == JFileChooser.APPROVE_OPTION) {
			saveFilePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (!saveFilePath.toLowerCase().endsWith(".wav")) {
				saveFilePath += ".wav";
			}
			//create the file
			File wavFile = new File(saveFilePath);

			try {
				recorder.save(wavFile);
				buttonPlay.setEnabled(true);
				Keyup.setEnabled(true);
				Keydown.setEnabled(true);
				getKey.setEnabled(true);
				

			} catch (IOException ex) {
				JOptionPane.showMessageDialog(Mainframe.this, "Error",
						"Error saving to sound file!",
						JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	// class called in constructor that loads the background image 
	class ContentPanel extends JPanel {
		  String path ="bg.jpg";
		  ImageIcon im = new ImageIcon(this.getClass().getResource(path)); 
		  Image img;
		  
		ContentPanel() {
		    MediaTracker mt = new MediaTracker(this);
		    img = im.getImage();
		    mt.addImage(img, 0);
		    try {
		      mt.waitForAll();
		    } catch (InterruptedException e) {
		      e.printStackTrace();
		    }
		  }

		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    int imwidth = img.getWidth(null);
		    int imheight = img.getHeight(null);
		    g.drawImage(img, 1, 1, null);
		  }

	}
	


	// main start point of the program
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe frame = new Mainframe();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}