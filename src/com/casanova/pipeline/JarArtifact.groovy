package com.casanova.pipeline

class JarArtifact implements Artifact, Serializable {
    void executeBuild(script) {
        script.echo "executing build Stage.."
        script.buildStep()
    }
    void executeQA(script){
        script.echo "executing QA Stage.."
        script.buildStep()
    }
    void executeCodeQuality(script){
        script.echo "executing Code Quality Stage.."
    }
    void executeDeliveryByBranch(script, String branch){
        script.echo "executing Delivery Stage... branch ${branch}"
    }

}