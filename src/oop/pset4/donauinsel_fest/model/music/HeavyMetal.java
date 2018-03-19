package oop.pset4.donauinsel_fest.model.music;

public class HeavyMetal implements Music{
    @Override
    public MusicType getType() {
        return MusicType.HEAVYMETAL;
    }
}
