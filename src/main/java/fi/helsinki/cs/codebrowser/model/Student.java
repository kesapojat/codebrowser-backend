package fi.helsinki.cs.codebrowser.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Student extends AbstractNamedPersistable {

    @ManyToMany
    private List<Course> courses;

    @JsonIgnore
    @ManyToMany
    private List<StudentGroup> groups;

    public List<Course> getCourses() {

        return courses;
    }

    public void setCourses(final List<Course> courses) {

        this.courses = courses;
    }

    public List<StudentGroup> getGroups() {

        return groups;
    }

    public void setGroups(final List<StudentGroup> groups) {

        this.groups = groups;
    }
}
