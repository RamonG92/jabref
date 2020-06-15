package org.jabref.asv;

import org.jabref.logic.msbib.MSBibConverter;
import org.jabref.logic.msbib.MSBibEntry;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.event.EntriesEventSource;
import org.jabref.model.entry.field.StandardField;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MsBibTest {

    BibEntry entry;
    BibEntry entry1;
    MSBibEntry msBibEntry;
    MSBibEntry msBibEntry1;

    @Before
    public void setup() {
        entry = new BibEntry();
        entry1 = new BibEntry();
        msBibEntry = new MSBibEntry();
        msBibEntry1 = new MSBibEntry();
    }

    @Test
    public void MsBibNoTypeConversionTest() {
        entry.setField(StandardField.TITLE, "A new Article");
        msBibEntry = MSBibConverter.convert(entry);
        Assert.assertEquals("string", msBibEntry.getType());
    }

    @Test
    public void MsBibTypeConversionTest() {
        entry1.setField(StandardField.TITLE, "A new Article");
        entry1.setType(null);
        msBibEntry1 = MSBibConverter.convert(entry);
        Assert.assertEquals("string", msBibEntry1.getType());
    }
}