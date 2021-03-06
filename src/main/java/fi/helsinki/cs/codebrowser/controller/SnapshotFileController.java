package fi.helsinki.cs.codebrowser.controller;

import fi.helsinki.cs.codebrowser.model.SnapshotFile;
import fi.helsinki.cs.codebrowser.service.SnapshotFileService;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.GET,
                value = { "{instanceId}/students/{studentId}/courses/{courseId}/exercises/{exerciseId}/snapshots/{snapshotId}/files",
                          "{instanceId}/courses/{courseId}/exercises/{exerciseId}/students/{studentId}/snapshots/{snapshotId}/files" },
                produces = "application/json")
public final class SnapshotFileController {

    @Autowired
    private SnapshotFileService snapshotFileService;

    @RequestMapping
    public Collection<SnapshotFile> list(@PathVariable final String instanceId,
                                         @PathVariable final String studentId,
                                         @PathVariable final String courseId,
                                         @PathVariable final String exerciseId,
                                         @PathVariable final String snapshotId) throws IOException {

        return snapshotFileService.findAllBy(instanceId, studentId, courseId, exerciseId, snapshotId);
    }

    @RequestMapping(value = "{fileId}")
    public SnapshotFile read(@PathVariable final String instanceId,
                             @PathVariable final String studentId,
                             @PathVariable final String courseId,
                             @PathVariable final String exerciseId,
                             @PathVariable final String snapshotId,
                             @PathVariable final String fileId) throws IOException {

        return snapshotFileService.findBy(instanceId, studentId, courseId, exerciseId, snapshotId, fileId);
    }

    @RequestMapping(value = "{fileId}/content", produces = "text/plain")
    public String readContent(@PathVariable final String instanceId,
                              @PathVariable final String studentId,
                              @PathVariable final String courseId,
                              @PathVariable final String exerciseId,
                              @PathVariable final String snapshotId,
                              @PathVariable final String fileId) throws IOException {

        return snapshotFileService.findContentBy(instanceId, studentId, courseId, exerciseId, snapshotId, fileId);
    }
}
