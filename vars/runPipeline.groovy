import com.casanova.pipeline.*

def call(body) {

    def actualConfig = [cq: true, qa: true, , publish: true, deploy: true]


    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    actualConfig.qa = (config.qa != null) ? config.qa : actualConfig.qa
    actualConfig.cq = (config.cq != null) ? config.cq : actualConfig.cq
    actualConfig.deploy = (config.deploy != null) ? config.deploy : actualConfig.deploy
    actualConfig.publish = (config.publish != null) ? config.publish : actualConfig.publish

    def artifact = new JarArtifact()

    executePipeline(this, actualConfig, artifact)

}