package ex46;

public class Word implements Comparable{

    String name;
    int frequency;

    public Word(String name)
    {
        this.name = name;
        frequency = 1;
    }

    public void incrementFreq()
    {
        frequency++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    private String freqToStars()
    {
        return "*".repeat(Math.max(0, frequency));
    }

    @Override
    public String toString() {
        return name + ":   " + freqToStars();
    }

    @Override
    public int compareTo(Object compareVal) {
        int compareFreq = ((Word)compareVal).getFrequency();

        return compareFreq - this.frequency;

    }


}
