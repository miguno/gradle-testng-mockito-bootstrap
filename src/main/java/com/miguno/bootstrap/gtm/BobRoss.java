package com.miguno.bootstrap.gtm;

import java.io.PrintStream;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

/**
 * 
 * testing master
 * testing helloworld
 * tetsing 1
 * testing 2gg
 * sss
 * yyy
 * 
 * testint 3hhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
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
