package org.jabref.asv;

import org.jabref.logic.msbib.MSBibConverter;
import org.jabref.logic.msbib.MSBibEntry;
import org.jabref.model.entry.BibEntry;
import org.jabref.model.entry.field.StandardField;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MsBibTest {

    BibEntry entry;
    BibEntry entry1;
    MSBibEntry msBibEntry;
    MSBibEntry msBibEntry1;

    @BeforeEach
    public void setup() {
        entry = new BibEntry();
        entry1 = new BibEntry();
        msBibEntry = new MSBibEntry();
        msBibEntry1 = new MSBibEntry();
    }

    @Test
    public void MsBibTypeConversionTest() {
        entry1.setField(StandardField.TITLE, "A new Article");
        msBibEntry1 = MSBibConverter.convert(entry1);
        assertEquals("Misc", msBibEntry1.getType());
    }

    @Test
    public void MsBibNoTypeConversionTest() {
        entry.setField(StandardField.TITLE, "A new Article");
        msBibEntry = MSBibConverter.convert(entry);
        assertEquals("Misc", msBibEntry.getType());
    }
}
