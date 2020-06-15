package org.jabref.asv;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.jabref.logic.shared.DBMSConnection;
import org.junit.jupiter.api.Test;

class DBMSConnectionTest {
    
    public DBMSConnection dbmsconnection;

    @Test
    void checkDBTypeTest() {
        dbmsconnection = mock(DBMSConnection.class);
        assertTrue(dbmsconnection.getAvailableDBMSTypes().toString().contains("MySQL"));
    }
}