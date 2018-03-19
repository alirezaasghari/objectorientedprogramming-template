package oop.pset4.donauinsel_fest.model.music;

public class Rock implements Music{
    @Override
    public MusicType getType() {
        return MusicType.ROCK;
    }
}
