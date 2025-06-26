package pl.ciecierski.model;

public enum Level {
    EASY(0.2F),
    MEDIUM(0.3F), HARD(0.4F),
    EXTREME(0.44F),
    IMPOSSIBLE47(0.47F),
    IMPOSSIBLE48(0.48F),
    IMPOSSIBLE49(0.49F),
    IMPOSSIBLE50(0.5F),
    IMPOSSIBLE51(0.51F),
    IMPOSSIBLE52(0.52F);


    private final float level;

    private Level(final float level) {
        this.level = level;
    }

    public float getLevel() {
        return level;
    }
}
