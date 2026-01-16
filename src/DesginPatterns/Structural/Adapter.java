package DesginPatterns.Structural;

public class Adapter {

    // Target Interface (Expected by Client)
    interface MediaPlayer {
        void play(String audioType, String fileName);
    }

    // Adaptee (Incompatible Interface)
    class AdvancedMediaPlayer {
        public void playVlc(String fileName) {
            System.out.println("Playing vlc file: " + fileName);
        }
    }

    // Adapter
    class MediaAdapter implements MediaPlayer {
        private AdvancedMediaPlayer advancedPlayer; // HAS-A

        public MediaAdapter() {
            advancedPlayer = new AdvancedMediaPlayer();
        }

        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")) {
                advancedPlayer.playVlc(fileName);
            }
        }
    }

    // Client
    class AudioPlayer implements MediaPlayer {
        private MediaAdapter mediaAdapter;

        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")) {
                System.out.println("Playing mp3 file: " + fileName);
            } else if (audioType.equalsIgnoreCase("vlc")) {
                mediaAdapter = new MediaAdapter();
                mediaAdapter.play(audioType, fileName);
            }
        }
    }


}
