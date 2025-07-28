import htsjdk.samtools.*;
import htsjdk.samtools.util.SequenceUtil;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

public class SamFileCreator {

    public static void main(String[] args) {
        String outputSamFilePath = "example.sam";
        
        // 1. Create a SAMFileHeader
        SAMFileHeader header = new SAMFileHeader();
        header.setSortOrder(SAMFileHeader.SortOrder.coordinate); // Important for many tools

        // Add reference sequences (chromosomes/contigs) to the header
        SAMSequenceRecord chr1 = new SAMSequenceRecord("chr1", 1000); // Name, length
        SAMSequenceRecord chr2 = new SAMSequenceRecord("chr2", 500);
        header.addSequence(chr1);
        header.addSequence(chr2);

        // Optional: Add a read group
        SAMReadGroupRecord readGroup = new SAMReadGroupRecord("rg1");
        readGroup.setSample("sampleA");
        header.addReadGroup(readGroup);

        // Optional: Add program record
        SAMProgramRecord program = new SAMProgramRecord("MySamCreator");
        program.setProgramName("SAM Creator Example");
        program.setProgramVersion("1.0");
        header.addProgramRecord(program);

        // 2. Create a SAMFileWriter
        SAMFileWriterFactory factory = new SAMFileWriterFactory();
        // You can specify makeSAMWriter for SAM, or makeBAMWriter for BAM
        // makeSAMOrBAMWriter determines based on file extension (.sam or .bam)
        SAMFileWriter writer = factory.makeSAMWriter(header, false, new File(outputSamFilePath));
        // 'false' for presorted means we'll add records in coordinate order.
        // If your records are not presorted, and you want a sorted output,
        // you'd typically write to a temp file and then sort with Picard/Samtools.
        // For this example, we'll assume we're adding them in coordinate order.

        try {
            // 3. Create and write SAMRecord objects
            
            // Example 1: A simple mapped read
            SAMRecord record1 = new SAMRecord(header);
            record1.setReadName("read_A_1");
            record1.setReferenceName("chr1");
            record1.setAlignmentStart(100); // 1-based start
            record1.setMappingQuality(60);
            record1.setCigarString("10M"); // 10 matches
            record1.setReadString("AAAAAAAAAA");
            record1.setBaseQualityString("!!!!!!!!!!"); // Phred+33 quality string
            record1.setAttribute(SAMTag.RG.name(), readGroup.getId()); // Associate with read group
            writer.addAlignment(record1);

            // Example 2: Another mapped read on chr1
            SAMRecord record2 = new SAMRecord(header);
            record2.setReadName("read_B_1");
            record2.setReferenceName("chr1");
            record2.setAlignmentStart(115); 
            record2.setMappingQuality(50);
            record2.setCigarString("5M5I5M"); //
