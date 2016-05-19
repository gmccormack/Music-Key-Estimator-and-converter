import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



public class Playwav implements LineListener {
	
	//Code Reference
	//Title: play file set up
	//Author: www.codejava.net
	//Date: 2016
	//Availability: www.codejava.net
	
	// check if play is completed
	boolean playCompleted;
	
	// chack if stopped
	boolean isStopped;

	// play the saved file back 
	void play(String audioFilePath) throws UnsupportedAudioFileException,
			IOException, LineUnavailableException {
		File audioFile = new File(audioFilePath);

		AudioInputStream audioStream = AudioSystem
				.getAudioInputStream(audioFile);

		AudioFormat format = audioStream.getFormat();

		DataLine.Info info = new DataLine.Info(Clip.class, format);

		Clip audioClip = (Clip) AudioSystem.getLine(info);

		audioClip.addLineListener(this);

		audioClip.open(audioStream);

		audioClip.start();
		
		playCompleted = false;
		
		while (!playCompleted) {
			// wait for the playback completes
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
				if (isStopped) {
					audioClip.stop();
					break;
				}
			}
		}

		audioClip.close();

	}

	// stop the play back
	public void stop() {
		isStopped = true;
	}
	
	// update completed play
	@Override
	public void update(LineEvent event) {
		LineEvent.Type type = event.getType();
		if (type == LineEvent.Type.STOP) {
			playCompleted = true;
		}
	}
}