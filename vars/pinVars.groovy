def call() {
    def pinVars = [:]

   

    pinVars.pushDockerImage = {  ->
        sh """
            docker push grupo7devops/pin1app:1.0.0
        """
    }

    pinVars.dockerLogin = { registryUrl ->
        withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
            withDockerRegistry([url: registryUrl]) {
                return true
            }
        }
        return false
    }

    return pinVars
}
