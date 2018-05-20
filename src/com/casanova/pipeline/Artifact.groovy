package com.casanova.pipeline

interface Artifact {
    void executeBuild(script)
    void executeQA(script)
    void executeCodeQuality(script)
    void executeDeliveryByBranch(script, String branch)
}