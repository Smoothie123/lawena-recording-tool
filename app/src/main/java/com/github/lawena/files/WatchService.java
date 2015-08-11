package com.github.lawena.files;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class WatchService extends Service<Void> {
    private static final Logger log = LoggerFactory.getLogger(WatchService.class);

    private final Resources resources;

    public WatchService(Resources resources) {
        this.resources = resources;
    }

    @Override
    protected void running() {
        log.debug("Service running"); //$NON-NLS-1$
        super.running();
    }

    @Override
    protected void succeeded() {
        log.debug("SUCCEEDED"); //$NON-NLS-1$
        super.succeeded();
    }

    @Override
    protected void failed() {
        log.debug("FAILED", getException()); //$NON-NLS-1$
        super.failed();
    }

    @Override
    protected Task<Void> createTask() {
        return new WatchTask(resources.foldersProperty().get()) {

            @Override
            public void entryModified(Path child) {
                // ignore these events
            }

            @Override
            public void entryDeleted(Path child) {
                resources.deleteResource(child);
            }

            @Override
            public void entryCreated(Path child) {
                resources.newResource(child);
            }
        };

    }

}