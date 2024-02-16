def call() {
    def pinVars = [:]

    pinVars.buildDockerImage = { imageName, version ->
        sh '''
                ls -la
                docker build -t $imageName:$version .
            '''
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
