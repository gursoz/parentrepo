package com.parent;


import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.InputDirectory;
import org.gradle.api.tasks.PathSensitive;
import org.gradle.api.tasks.PathSensitivity;
import org.gradle.api.tasks.options.Option;
import org.gradle.api.tasks.Nested;
import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.tasks.CacheableTask;
import org.gradle.api.file.*;
import java.time.LocalDateTime;

@CacheableTask
abstract class TridentBuild extends DefaultTask {

    @Input
    String forceBuild = ""

    @InputDirectory
    abstract DirectoryProperty getSrcDir();

    @OutputDirectory
    abstract DirectoryProperty getOutputDir(); 

    @TaskAction
    public void build() {
        // TODO: System.out.println("Starting build " + srcDir);
        setForceBuild(false)
        doBuild();
    }
 
    @Option( option = 'force', description = 'Build even if not stale in cache. Will force build only this repo')
    void isForceBuild(final Boolean ignoreVal) {
       setForceBuild(true)
    }

    void setForceBuild(Boolean doSet) {
      if(doSet) {
        forceBuild = LocalDateTime.now().toString()
      }
      else {
        forceBuild = "" 
      }

    }
   

    abstract void doBuild();
    
}
