package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = new Employer(employer.getValue());
        this.location = new Location(location.getValue());
        this.positionType = new PositionType(positionType.getValue());
        this.coreCompetency = new CoreCompetency(coreCompetency.getValue());
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        String lineSeparator = System.lineSeparator();
        String name = this.getName();
        String employer = this.getEmployer().toString();
        String location = this.getLocation().toString();
        String positionType = this.getPositionType().toString();
        String coreCompetency = this.getCoreCompetency().toString();

        if (employer.isEmpty()) {
            employer = "Data not available";
        }

        return lineSeparator + "ID: " + this.getId() + lineSeparator + "Name: " + this.getName() + lineSeparator +
                "Employer: " + employer + lineSeparator + "Location: " + this.getLocation() + lineSeparator +
                "Position Type: " + this.getPositionType() + lineSeparator + "Core Competency: " + this.getCoreCompetency()
                + lineSeparator;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public Employer getEmployer() {
        return employer;
    }

    public String getName() {
        return name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
}


