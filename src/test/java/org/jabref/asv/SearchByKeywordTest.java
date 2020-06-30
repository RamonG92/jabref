package org.jabref.asv;

import java.util.List;

import org.jabref.logic.search.DatabaseSearcher;
import org.jabref.logic.search.SearchQuery;
import org.jabref.model.database.BibDatabase;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchByKeywordTest {

    @Test
    public void searchResultTest() {
        BibEntry bibEntry1 = new BibEntry();
        BibDatabase bibDb = new BibDatabase();

        // bibEntry1.setType(BibEntry.DEFAULT_TYPE);
        bibEntry1.setField(StandardField.TITLE, "A new Book");
        bibEntry1.setField(StandardField.AUTHOR, "Mr Swordfish");
        bibEntry1.setField(StandardField.JOURNAL, "Journal about the animal Swordfish");

        bibDb.insertEntry(bibEntry1);

        SearchQuery query = new SearchQuery("Swordfish", false, false);
        List<BibEntry> queryResult = new DatabaseSearcher(query, bibDb).getMatches();

        assertEquals(bibEntry1, queryResult.iterator().next());
    }
}
