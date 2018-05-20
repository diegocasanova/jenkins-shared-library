import com.casanova.pipeline.*

def call(scr, Map config, Artifact artifact) {
    pipeline {
        agent any
        stages {
            stage('Build') {
                steps {
                    script {
                        artifact.executeBuild(this)
                    }
                }
            }
            stage('QA Stage') {
                when { equals expected: true, actual: config.qa }
                steps {
                    script {
                        artifact.executeQA(this)
                    }
                }
            }
            stage('Code Quality Stage') {
                when { equals expected: true, actual: config.cq }
                steps {
                    script {
                        artifact.executeCodeQuality(this)
                    }
                    
                }
            }
            stage('Publish & Deploy Stage') {
                when { equals expected: true, actual: config.publish }
                steps {
                    script {
                        artifact.executeDeliveryByBranch(this, env.BRANCH_NAME)
                    }
                }
            }
        }
    }
}