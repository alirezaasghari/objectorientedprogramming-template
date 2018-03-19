package oop.pset4.donauinsel_fest.controller;

import oop.pset4.donauinsel_fest.model.music.HeavyMetal;
import oop.pset4.donauinsel_fest.model.music.Music;
import oop.pset4.donauinsel_fest.model.music.Pop;
import oop.pset4.donauinsel_fest.model.music.Rock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class musicFactory {
    public List<Music> makeMusic() {
        return Stream.of(
                new Rock(),
                new HeavyMetal(),
                new Pop())
                .collect(Collectors.toList());
    }
}
