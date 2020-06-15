package org.jabref.asv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Optional;

import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.ImportFormatPreferences;
import org.jabref.logic.importer.fetcher.IsbnFetcher;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;
import org.jabref.model.entry.types.BiblatexEntryTypeDefinitions;
import org.jabref.model.entry.types.EntryType;
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
        bibEntry.setType((EntryType) BiblatexEntryTypeDefinitions.BOOK);
        bibEntry.setField(StandardField.KEY, "9781317356660");
        bibEntry.setField(StandardField.AUTHOR, "Huber, David");
        bibEntry.setField(StandardField.TITLE, "Modern Recording Techniques");
        bibEntry.setField(StandardField.PUBLISHER, "Taylor & Francis");
        bibEntry.setField(StandardField.PAGETOTAL, "652");
        bibEntry.setField(StandardField.DATE, "2017-09-05");
        bibEntry.setField(StandardField.ISBN, "9781317356660");
        bibEntry.setField(StandardField.YEAR, "2017");
        bibEntry.setField(StandardField.URL, "https://www.ebooks.com/en-nl/book/95802408/modern-recording-techniques/david-miles-huber/");
    }

    @Test
    public void searchByIsbn() throws FetcherException {
        Optional<BibEntry> fetchedEntry = fetcher.performSearchById("9781317356660");
        assertEquals(Optional.of(bibEntry), fetchedEntry);
    }
}