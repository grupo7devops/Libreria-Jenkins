// En pinVars.groovy

def call() {
    def pinVars = [:]

    pinVars.buildDockerImage = { imageName, version,  ->
        echo "Directorio actual: ${pwd()}"
        dir(directory) {
            sh '''
                ls -la
            '''
        }
    }

    pinVars.pushDockerImage = { imageName, version, directory ->
        sh """
            docker push $imageName:$version
        """
    }

        pinVars.dockerHubLogin = { username, password ->
        def dockerLoginCommand = """
            docker login -u ${username} -p ${password}
        """
        sh dockerLoginCommand
    }


    return pinVars
}
