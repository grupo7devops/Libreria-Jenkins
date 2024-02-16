// pinVars.groovy

def call() {
    def pinVars = [:]

    pinVars.dockerLogin = { registryUrl, credentialsId ->
        withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
            withDockerRegistry([url: registryUrl]) {
                return true
            }
        }
        return false
    }

    pinVars.buildDockerImage = { imageName ->
        sh "docker build -t ${imageName} ."
    }

    pinVars.pushDockerImage = { imageName ->
        sh "docker push ${imageName}"
    }

    return pinVars
}
