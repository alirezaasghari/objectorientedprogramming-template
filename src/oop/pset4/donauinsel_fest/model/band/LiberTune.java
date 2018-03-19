package oop.pset4.donauinsel_fest.model.band;

import oop.pset4.donauinsel_fest.controller.musicFactory;
import oop.pset4.donauinsel_fest.model.music.Music;

import java.util.Collections;
import java.util.List;

public class LiberTune implements Band {
    @Override
    public Music getMusic() {
        List<Music> liberTuneMusic = new musicFactory().makeMusic();
        Collections.shuffle(liberTuneMusic);
        Music firstMusic = liberTuneMusic.get(0);
        return firstMusic;

    }
}
