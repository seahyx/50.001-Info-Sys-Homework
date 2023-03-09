package piano;

import javax.sound.midi.MidiUnavailableException;

import midi.Midi;
import music.Pitch;

/**
 * Created by ngaiman_cheung on 17/10/16.
 */
public class TestPiano {
    public static void main(String[] args) {

        try {
            Midi midi;
            PianoMachine pm = new PianoMachine();
            midi = Midi.getInstance();
            midi.clearHistory();
            pm.beginNote(new Pitch(0));
            Midi.rest(10);
            pm.endNote(new Pitch(0));

            pm.changeInstrument();
            Midi.rest(10);
            pm.changeInstrument();
            pm.beginNote(new Pitch(2));
            Midi.rest(10);
            pm.endNote(new Pitch(2));

            System.out.println(midi.history());
            midi.clearHistory();

            pm.shiftUp();
            pm.beginNote(new Pitch(2));
            Midi.rest(10);
            pm.endNote(new Pitch(2));
            pm.shiftDown();

            System.out.println(midi.history());
            midi.clearHistory();

            pm.toggleRecording();
            pm.beginNote(new Pitch(3));
            pm.beginNote(new Pitch(5));
            Midi.rest(10);
            pm.endNote(new Pitch(3));
            pm.endNote(new Pitch(5));
            pm.toggleRecording();

            System.out.println(midi.history());
            midi.clearHistory();
            Midi.rest(10);

            pm.playback();
            Midi.rest(10);

            System.out.println(midi.history());

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }



    }

}