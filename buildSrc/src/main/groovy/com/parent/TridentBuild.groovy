package com.parent;


import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.file.*;

@CacheableTask
abstract class TridentBuild extends DefaultTask {

    @InputDirectory
    abstract DirectoryProperty getSrcDir();

    @OutputDirectory
    abstract DirectoryProperty getOutputDir(); 

    @Input
    abstract Map<String,String> getInputProperties();

    @TaskAction
    public void build() {
        // TODO: System.out.println("Starting build " + srcDir);
        doBuild();
    }
 
    abstract void doBuild();
    
}
