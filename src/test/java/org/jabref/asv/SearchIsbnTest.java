package org.jabref.asv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.Optional;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.fetcher.IsbnFetcher;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

public class SearchIsbnTest {

    private BibEntry bibEntry;
    private IsbnFetcher fetcher;

    @BeforeEach
    public void setup() {
        fetcher = new IsbnFetcher(mock(ImportFormatPreferences.class, Answers.RETURNS_DEEP_STUBS));

        bibEntry = new BibEntry();
        // bibEntry.setType(BibEntry.DEFAULT_TYPE);
        // bibEntry.setField(StandardField.KEY, "9781317356660");
        bibEntry.setField(StandardField.AUTHOR, "Huber, David");
        bibEntry.setField(StandardField.TITLE, "Modern recording techniques");
        bibEntry.setField(StandardField.PUBLISHER, "Routledge");
        bibEntry.setField(StandardField.ISBN, "9781317356660");
        bibEntry.setField(StandardField.YEAR, "2018");
        bibEntry.setField(StandardField.URL, "https://www.ebook.de/de/product/30052873/david_miles_huber_robert_e_runstein_modern_recording_techniques.html?internal-rewrite=true");
    }

    @Test
    public void searchByIsbnTest() throws FetcherException {
        Optional<BibEntry> fetchedEntry = fetcher.performSearchById("9781317356660");
        assertEquals(Optional.of(bibEntry), fetchedEntry);
    }
}