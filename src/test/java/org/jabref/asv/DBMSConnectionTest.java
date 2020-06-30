package org.jabref.asv;

import org.jabref.logic.shared.DBMSConnection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

class DBMSConnectionTest {
    
    public DBMSConnection dbmsconnection;

    @Test
    void checkDBTypeTest() {
        dbmsconnection = mock(DBMSConnection.class);
        assertTrue(DBMSConnection.getAvailableDBMSTypes().toString().contains("MySQL"));
    }
}
