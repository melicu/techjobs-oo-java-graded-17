package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.getName() instanceof String);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job1.getName(), "Product tester");
        assertEquals(job1.getEmployer().toString(), "ACME");
        assertEquals(job1.getLocation().toString(), "Desert");
        assertEquals(job1.getPositionType().toString(), "Quality control");
        assertEquals(job1.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job();
        Job job2 = new Job();
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertNotEquals(job1, job2);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String lineSeparator = System.lineSeparator();
        Job job1 = new Job();
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.toString().startsWith("\r\n"));
        assertTrue(job1.toString().endsWith("\r\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String lineSeparator = System.lineSeparator();
        Job job1 = new Job();
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1Data = lineSeparator + "ID: " + job1.getId() + lineSeparator + "Name: Product tester" +
                lineSeparator + "Employer: ACME" + lineSeparator + "Location: Desert" +
                lineSeparator + "Position Type: Quality control" + lineSeparator + "Core Competency: Persistence" + lineSeparator;
        assertEquals(job1.toString(), job1Data);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String lineSeparator = System.lineSeparator();
        Job job1 = new Job();
        job1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String job1Data = lineSeparator + "ID: " + job1.getId() + lineSeparator + "Name: Product tester" +
                lineSeparator + "Employer: Data not available" + lineSeparator + "Location: Desert" +
                lineSeparator + "Position Type: Quality control" + lineSeparator + "Core Competency: Persistence" + lineSeparator;
        assertEquals(job1.toString(), job1Data);
    }
}
