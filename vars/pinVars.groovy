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

    return pinVars
}
