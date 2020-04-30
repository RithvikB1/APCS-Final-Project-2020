package other;

// Class: Music
// Version 2.0
// Author(s): David
// Description: This class puts the music of the game, and is used by PizzaMan
// Source of Music: https://www.youtube.com/watch?v=oMgQJEcVToY&list=PLzjkiYUjXuevVG0fTOX4GCTzbU0ooHQ-O&index=1
// Relationships: None

import java.io.File;

import javax.sound.sampled.*;

public class Sound {
	
	private Clip clip;
	
	public void PlaySound(File Sound) { // This method will play the sound created in this class
		try {
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		} 
		catch (Exception e) { 
			System.out.println("Hmm, if you see this, it means the audio file isn't being read properly and idk why");
		}

	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}