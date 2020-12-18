package com.jr.level.level33.task3310;

import com.jr.level.level33.task3310.strategy.DualHashBidiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.FileStorageStrategy;
import com.jr.level.level33.task3310.strategy.HashBiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.HashMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.OurHashBiMapStorageStrategy;
import com.jr.level.level33.task3310.strategy.OurHashMapStorageStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortenerTest {
    @Test
    public void testHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy(){
        Shortener shortener = new Shortener(new FileStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy(){
        Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy(){
        Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
        testStorage(shortener);
    }

    //Base test for testing
    public void testStorage(Shortener shortener){
        String oneBefore = Helper.generateRandomString();
        String twoBefore = Helper.generateRandomString();
        String threeBefore = new String(oneBefore);
        Long idOne = shortener.getId(oneBefore);
        Long idTwo = shortener.getId(twoBefore);
        Long idThree = shortener.getId(threeBefore);

        assertNotEquals(idOne, idTwo);
        assertNotEquals(idThree, idTwo);
        assertEquals(idOne, idThree);

        String oneAfter = shortener.getString(idOne);
        String twoAfter = shortener.getString(idTwo);
        String threeAfter = shortener.getString(idThree);

        assertEquals(oneBefore, oneAfter);
        assertEquals(twoBefore, twoAfter);
        assertEquals(threeBefore, threeAfter);
    }
}
