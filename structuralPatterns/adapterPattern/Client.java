package adapterPattern;

//Existing audio player interface
interface AudioPlayer {
	void play(String fileName);
}

//Existing audio player implementation
class Mp3Player implements AudioPlayer {
	@Override
	public void play(String fileName) {
		System.out.println("Playing MP3 file: " + fileName);
	}
}

//New audio library with a different interface
class NewAudioLibrary {
	void playMp4(String fileName) {
		System.out.println("Playing MP4 file: " + fileName);
	}

	void playOgg(String fileName) {
		System.out.println("Playing Ogg file: " + fileName);
	}
}

//Adapter class to make the new audio library work with the existing audio player
class AudioPlayerAdapter implements AudioPlayer {
	private NewAudioLibrary newAudioLibrary;

	public AudioPlayerAdapter(NewAudioLibrary newAudioLibrary) {
		this.newAudioLibrary = newAudioLibrary;
	}

	@Override
	public void play(String fileName) {
		if (fileName.endsWith(".mp4")) {
			newAudioLibrary.playMp4(fileName);
		} else if (fileName.endsWith(".ogg")) {
			newAudioLibrary.playOgg(fileName);
		} else {
			System.out.println("Invalid audio format: " + fileName);
		}
	}
}

public class Client {
	public static void main(String[] args) {
		// Use the existing audio player with MP3 file
		AudioPlayer mp3Player = new Mp3Player();
		mp3Player.play("song.mp3");

		// Use the new audio library through the adapter with MP4 and Ogg files
		NewAudioLibrary newAudioLibrary = new NewAudioLibrary();
		AudioPlayer audioPlayerAdapter = new AudioPlayerAdapter(newAudioLibrary);
		audioPlayerAdapter.play("video.mp4");
		audioPlayerAdapter.play("sound.ogg");
	}
}