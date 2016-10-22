package com.epam.daria_ivanova2.task2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArraySetTest {
    
    private ArraySet arraySet = new ArraySet();
    private String[] stringArray;
    
    @Before
    public void setArraySet() {
        stringArray = new String[]{"abc", "$#%$#%$", "232"};
        arraySet.setArray(stringArray);
    }
    
    @Test
    public void verifyArrayContainsElementFromArray() {
        for (String s : stringArray) {
            assertTrue(arraySet.contains(s));
        }
    }
    
    @Test
    public void verifyArrayDoesNotContainElementFromArray() {
        assertFalse(arraySet.contains("blalalala"));
    }
    
    @Test
    public void verifyArrayContainsAddedElement() {
        String addedElement = "some new string";
        arraySet.add(addedElement);
        assertEquals(stringArray.length + 1, arraySet.getArray().length);
        assertEquals(addedElement, arraySet.getArray()[stringArray.length].toString());
    }
    
    @Test
    public void verifyExistingElementIsNotAdded() {
        arraySet.add(stringArray[1]);
        assertEquals(stringArray.length, arraySet.getArray().length);
        assertArrayEquals(stringArray, arraySet.getArray());
    }
    
    @Test
    public void verifyElementIsAddedWhenArraySetIsEmpty() {
        ArraySet emptyArray = new ArraySet();
        String firstElement = "very first element";
        emptyArray.add(firstElement);
        assertEquals(1, emptyArray.getArray().length);
        assertEquals(firstElement, emptyArray.getArray()[0]);
    }
    
    @Test
    public void verifySizeEqualsExpectedSize() {
        assertEquals(stringArray.length, arraySet.size());
    }
    
    @Test
    public void verifyIsEmptyReturnsTrueWhenArraySetIsEmpty() {
        ArraySet emptyArray = new ArraySet();
        assertTrue(emptyArray.isEmpty());
    }
    
    @Test
    public void verifyIsEmptyReturnsFalseWhenArraySetIsNotEmpty() {
        assertFalse(arraySet.isEmpty());
    }
    
    @Test
    public void verifyToArrayReturnsExpectedArray() {
        assertArrayEquals(stringArray, arraySet.toArray());
    }
    
    @Test
    public void verifyFirstElementIsRemoved() {
        String deletedElement = stringArray[0];
        arraySet.remove(deletedElement);
        assertEquals(arraySet.getArray().length, stringArray.length - 1);
        String [] expectedArray = new String[]{stringArray[1], stringArray[2]};
        assertArrayEquals(expectedArray, arraySet.getArray());
    }
    
    @Test
    public void verifyLastElementIsRemoved() {
        String deletedElement = stringArray[2];
        arraySet.remove(deletedElement);
        assertEquals(arraySet.getArray().length, stringArray.length - 1);
        String [] expectedArray = new String[]{stringArray[0], stringArray[1]};
        assertArrayEquals(expectedArray, arraySet.getArray());
    }
    
    @Test
    public void verifyMiddleElementIsRemoved() {
        String deletedElement = stringArray[1];
        arraySet.remove(deletedElement);
        assertEquals(arraySet.getArray().length, stringArray.length - 1);
        String [] expectedArray = new String[]{stringArray[0], stringArray[2]};
        assertArrayEquals(expectedArray, arraySet.getArray());
    }
    
    @Test
    public void verifyArrayWasNotChangedWhenNonexistingElementRemoved(){
        arraySet.remove("nonexisting element!");
        assertArrayEquals(stringArray, arraySet.getArray());
    }
    
    @Test
    public void verifyEmptyArrayWasNotChangedOnRemove(){
        ArraySet emptyArray = new ArraySet();
        emptyArray.remove("nonexisting element!");
        assertTrue(emptyArray.getArray().length==0);
    }
    
    @Test
    public void verifyArrayWithOnlyOneElementBecomesEmptyWhenRemoveThisElement(){
        ArraySet oneElementArray = new ArraySet();
        String oneElement = "the only one";
        oneElementArray.setArray(new String[] {});
        oneElementArray.remove(oneElement);
        assertTrue(oneElementArray.getArray().length==0);
    }
}
