package org.jabref.asv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.jabref.logic.bibtex.BibEntryWriter;
import org.jabref.logic.bibtex.FieldWriter;
import org.jabref.logic.bibtex.FieldWriterPreferences;
import org.jabref.logic.importer.FetcherException;
import org.jabref.logic.importer.fetcher.SpringerFetcher;
import org.jabref.model.database.BibDatabaseMode;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.BibEntryTypesManager;
import org.jabref.model.entry.field.StandardField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

public class BibTexTest {

    private BibEntry bibEntry;

    private BibEntryWriter writer;

    @BeforeEach
    public void setup() {
        FieldWriterPreferences fieldWriterPreferences = mock(FieldWriterPreferences.class, Answers.RETURNS_DEEP_STUBS);
        writer = new BibEntryWriter(new FieldWriter(fieldWriterPreferences), new BibEntryTypesManager());
        bibEntry = new BibEntry();
        
    }    
/** 
    @Test
    public void testGenerateBibTex() throws IOException
    {
        StringWriter bibTexOutput = new StringWriter();
        BibEntry bibEntry1 = new BibEntry();

        // Create an entry for the library
        bibEntry1.setField(StandardField.TITLE, "A new Book");
        bibEntry1.setField(StandardField.AUTHOR, "Mr Swordfish");
        bibEntry1.setField(StandardField.JOURNAL, "Journal about the animal, Swordfish");

        writer.write(bibEntry1, bibTexOutput, BibDatabaseMode.BIBTEX);

        String result = bibTexOutput.toString();

        String expected = "\n@Misc{,\n" +
                "  author  = {Mr Swordfish},\n" +
                "  title   = {A new Book},\n" +
                "  journal = {Journal about the animal, Swordfish},\n" +
                "}\n";

        assertEquals(expected, result);
    }
*/
    @Test
    public void testChangedValue() throws Exception {
        bibEntry.setField(StandardField.KEYWORDS, "Shark, Fish");
        bibEntry.putKeywords(Arrays.asList("Dolphin", "Mamal"), ',');
        assertTrue(bibEntry.hasChanged());
    }
/** 
    @Test
    public void testSpringerResults() throws FetcherException
    {
        SpringerFetcher sf = new SpringerFetcher();

        // Preform search about a given subject
        List<BibEntry> results = sf.performSearch("Bitcoin");

        // State that there are more results then 0
        assertTrue(results.size() > 0);

        // Iterate over the results
        Iterator<BibEntry> i = results.iterator();
        while (i.hasNext()) {
            BibEntry bibEntry1 = i.next();

            assertNotNull(bibEntry1.getField(StandardField.TITLE));
            assertNotNull(bibEntry1.getField(StandardField.AUTHOR));
            assertNotNull(bibEntry1.getField(StandardField.JOURNAL));
        }
    }
    */
}