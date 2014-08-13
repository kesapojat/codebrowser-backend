package fi.helsinki.cs.codebrowser.codeanalyzer.model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DiffList implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int lines;

    @OneToMany
    private List<Diff> differences;

    /**
     * @return the amount of inserted lines
     */
    public int getInserted() {

        int inserted = 0;
        for (Diff diff : differences) {
            if (diff.getType().equals("insert")) {
                inserted += diff.getRowEnd() - diff.getRowStart() + 1;
            }
        }
        return inserted;
    }

    /**
     * @return amount of replaced lines
     */
    public int getModified() {

        int modified = 0;
        for (Diff diff : differences) {
            if (diff.getType().equals("replace")) {
                modified += diff.getRowEnd() - diff.getRowStart() + 1;
            }
        }
        return modified;
    }

    /**
     * @return amount of deleted lines
     */
    public int getDeleted() {

        int deleted = 0;
        for (Diff diff : differences) {
            if (diff.getType().equals("delete")) {
                deleted += diff.getRowEnd() - diff.getRowStart() + 1;
            }
        }
        return deleted;
    }

    /**
     * @return the differences
     */
    public List<Diff> getDifferences() {

        return differences;
    }

    /**
     * @param differences the differences to set
     */
    public void setDifferences(final List<Diff> differences) {

        this.differences = differences;
    }

    /**
     * @return the total amount of changes
     */
    public int getTotal() {

        return getInserted() + getDeleted() + getModified();
    }

    /**
     * @return the lines
     */
    public int getLines() {

        return lines;
    }

    /**
     * @param lines the lines to set
     */
    public void setLines(final int lines) {

        this.lines = lines;
    }
}
