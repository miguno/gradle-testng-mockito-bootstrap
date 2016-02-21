package com.miguno.bootstrap.gtm;

import java.io.PrintStream;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

/**
 * 
 * 
 * shailendra kumar
 * A simple class that implements a few features that we can write unit tests for. It uses Google Guava for the sole
 * reason that we have an external compile-time dependency in this bootstrap project.
 * 
 * To make the example code simpler this class does not follow pure OO style. (If it did, we would create a Painting
 * object from painting elements and let our painter paint that painting object, for instance.)
 * 
 * "And from all of us here I'd like to wish you happy painting and God bless, my friend."
 */
public class BobRoss {

    private final Set<String> paintingElements;
    private final PrintStream printStream;

    public BobRoss(Set<String> paintingElements) {
        this(paintingElements, System.out);
    }

    public BobRoss(Set<String> paintingElements, PrintStream printStream) {
        Builder<String> builder = new ImmutableSet.Builder<String>().addAll(paintingElements);
        if (!paintingElements.contains("happy tree")) {
            builder.add("happy tree");
        }
        this.paintingElements = builder.build();
        this.printStream = printStream;
    }

    public Set<String> getPaintingElements() {
        return this.paintingElements;
    }

    public void paintPicture() {
        for (String p : paintingElements) {
            printStream.println("Now we will paint the " + p);
        }
    }

    public static void main(String[] args) {
        Set<String> paintingElements = ImmutableSet.of("sky", "lake", "mountain", "happy tree", "little squirrel");
        BobRoss bob = new BobRoss(paintingElements);
        bob.paintPicture();
    }

}
