package sample.Model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class RandomGen {
    private final int DEFAULT_RAN_SIZE = 10;
    Random random;
    Set<Integer> generated;
    private int sequenceLength;
    private int[] generatedSeq;
    private int r;

    private void initDefault() {
        random = new Random();
        generated = new LinkedHashSet<Integer>();
        r=1;
    }

    public RandomGen() {
        initDefault();
        generatedSeq = new int[DEFAULT_RAN_SIZE];
        sequenceLength = DEFAULT_RAN_SIZE;
        fillData(sequenceLength);
    }

    public RandomGen(int size) {
        initDefault();
        generatedSeq = new int[size];
        sequenceLength = (size <= 0)
                ? DEFAULT_RAN_SIZE
                : size;
        fillData(sequenceLength);
    }

    public int getSequenceLength() {
        return sequenceLength;
    }

    public Set<Integer> getGenerated() {
        return generated;
    }

    public int[] getGeneratedSeq() {
        return generatedSeq;
    }

    private void fillData(int length) {
        while (generated.size() < length) {
            /*r*=5;
            r=r%(sequenceLength*4);
            generated.add(r/4);
            */
            generated.add(random.nextInt(length));

        }
        Iterator iterator = generated.iterator();
        int counter = 0;

        while(iterator.hasNext()) {
            generatedSeq[counter] = (int) iterator.next();
            counter++;
        }
    }
}
