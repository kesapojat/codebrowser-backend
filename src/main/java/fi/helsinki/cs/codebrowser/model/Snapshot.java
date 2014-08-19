package fi.helsinki.cs.codebrowser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class Snapshot implements Comparable<Snapshot> {

    private String id;

    @JsonIgnore
    private String type;

    private Date timestamp;
    private List<SnapshotFile> files;

    @JsonIgnore
    private Exercise exercise;

    @JsonIgnore
    private Course course;

    @JsonIgnore
    private boolean compiles;

    public String getType() {

        return type;
    }

    public void setType(final String type) {

        this.type = type;
    }

    public Date getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(final Date timestamp) {

        this.timestamp = timestamp;
    }

    public List<SnapshotFile> getFiles() {

        return files;
    }

    public void setFiles(final List<SnapshotFile> snapshotFiles) {

        this.files = snapshotFiles;
    }

    public Exercise getExercise() {

        return exercise;
    }

    public void setExercise(final Exercise exercise) {

        this.exercise = exercise;
    }

    public Course getCourse() {

        return course;
    }

    public void setCourse(final Course course) {

        this.course = course;
    }

    public boolean getCompiles() {

        return compiles;
    }

    public void setCompiles(final boolean compiles) {

        this.compiles = compiles;
    }

    public String getId() {

        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    @Override
    public int compareTo(final Snapshot o) {

        return this.timestamp.compareTo(o.timestamp);
    }
}
