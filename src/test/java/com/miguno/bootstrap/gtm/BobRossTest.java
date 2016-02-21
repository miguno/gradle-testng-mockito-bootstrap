package com.miguno.bootstrap.gtm;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableSet;

/**
 * 
 * sss
 * 
 * kumar
 * dddddddd
 * ramss
 * This test class shows how to write unit tests with TestNG, Mockito and FEST-Assert 2.
 * 
 * Don't pay too much attention to the semantics of the actual tests.
 */
public class BobRossTest {

    private static final Set<String> ANY_PAINTING_ELEMENTS = ImmutableSet.of("sky", "mountain", "happy tree");
    private static final Set<String> ANY_PAINTING_ELEMENTS_BUT_NO_HAPPY_TREE = ImmutableSet.of("sky", "mountain");

    /**
     * Shows using mocks
     */
    @Test
    public void shouldCommunicateWhenPainting() {
        // given
        PrintStream printStream = mock(PrintStream.class);
        BobRoss bob = new BobRoss(ANY_PAINTING_ELEMENTS, printStream);

        // when
        bob.paintPicture();

        // then
        verify(printStream, times(ANY_PAINTING_ELEMENTS.size())).println(any(String.class));
    }

    /**
     * Shows testing for expected exceptions
     */
    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void shouldReturnImmutableSetOfPaintingElements() {
        // given
        BobRoss example = new BobRoss(ANY_PAINTING_ELEMENTS);

        // when
        Set<String> paintingElements = example.getPaintingElements();

        // then
        paintingElements.add("happy little accident");
    }

    @DataProvider
    public Object[][] paintingElementsWithoutHappyTreeData() {
        return new Object[][] {
                { ImmutableSet.of("sky", "mountain", "cloud") },
                { ImmutableSet.of("sky", "lake", "barn", "squirrel") } };
    }

    /**
     * Shows the use of data providers in TestNG and of assertThat() in FEST-Assert 2.x
     */
    @Test(dataProvider = "paintingElementsWithoutHappyTreeData")
    public void shouldAlwaysPaintAHappyTree(Set<String> paintingElementsWithoutHappyTree) {
        // given
        BobRoss bob = new BobRoss(ANY_PAINTING_ELEMENTS_BUT_NO_HAPPY_TREE);

        // when
        Set<String> paintingElements = bob.getPaintingElements();

        // then
        assertThat(paintingElements).contains("happy tree");
    }
}
