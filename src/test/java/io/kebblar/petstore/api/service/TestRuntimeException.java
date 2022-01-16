package io.kebblar.petstore.api.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.ibatis.exceptions.PersistenceException;
import org.junit.Test;

public class TestRuntimeException {
    @Test
    public void Test() {
        try {
            ok();
            assertTrue(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(true);
        }
    }
    
    private void ok() throws PersistenceException {
        throw new PersistenceException("Si la Cachó el try");
    }
}
