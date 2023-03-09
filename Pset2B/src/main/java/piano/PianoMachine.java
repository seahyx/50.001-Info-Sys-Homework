package piano;

import java.util.ArrayList;
import java.util.function.Predicate;

import javax.sound.midi.MidiUnavailableException;

import midi.Instrument;
import midi.Midi;
import music.Pitch;

public class PianoMachine {
	
	private Midi midi;
	private Instrument currentInstrument = Midi.DEFAULT_INSTRUMENT;

	private ArrayList<Pitch> playingNotes = new ArrayList<>(12);

	private int currentOctave = 0;

	private boolean isRecording = false;
	private String recording;

	/**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }

	/**
	 * Begins playing a note.
	 * @param rawPitch Pitch of the note.
	 */
	public void beginNote(Pitch rawPitch) {
		rawPitch.transpose(12 * currentOctave);
		for (Pitch p: playingNotes) {
			if (p == rawPitch) return; // Same note already playing, ignore.
		}
		playingNotes.add(rawPitch);
    	midi.beginNote(rawPitch.toMidiFrequency(), currentInstrument);
    }

	/**
	 * Ends a playing note.
	 * @param rawPitch Pitch of the note.
	 */
    public void endNote(final Pitch rawPitch) {
	    rawPitch.transpose(12 * currentOctave);
	    final boolean b = playingNotes.removeIf(new Predicate<Pitch>() {
		    @Override
		    public boolean test(Pitch p) {
			    return p == rawPitch;
		    }
	    });
	    midi.endNote(rawPitch.toMidiFrequency(), currentInstrument);
    }

	/**
	 * Change the instrument of the midi device.
	 */
	public void changeInstrument() {
		currentInstrument = currentInstrument.next();
    }

	/**
	 * Shift up one octave in the midi instrument.
	 */
	public void shiftUp() {
		if (currentOctave < 2) currentOctave++;
    }

	/**
	 * Shift down one octave in the midi instrument.
	 */
	public void shiftDown() {
		if (currentOctave > -2) currentOctave--;
    }

	/**
	 * Toggles recording.
	 * @return
	 */
	public boolean toggleRecording() {
		if (!isRecording) {
			midi.clearHistory();
			isRecording = true;
		}
		else
		{
			recording = midi.history();
			isRecording = false;
		}
		return isRecording;
    }

	/**
	 * Plays back recording.
	 */
    public void playback() {
		String[] noteSeq = recording.split(" ");
		for (String event: noteSeq) {
			String[] params = event.substring(event.indexOf("(")+1, event.indexOf(")")).split(",");
			switch (event.substring(0, 2)) {
				case "on":
					midi.beginNote(Integer.parseInt(params[0]), Instrument.valueOf(params[1]));
					break;
				case "of":
					midi.endNote(Integer.parseInt(params[0]), Instrument.valueOf(params[1]));
					break;
				case "re":
					Midi.rest(Integer.parseInt(params[0]));
					break;
			}
		}
    }

}
