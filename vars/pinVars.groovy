// DockerHelper.groovy

def buildAndPushDockerImage(String imageName, String version, String directory) {
    try {
        // Tu lógica de construcción de la imagen Docker aquí
        sh "docker build -t $imageName:$version $directory"
        
        // Tu lógica de empujar la imagen Docker aquí
        sh "docker push $imageName:$version"
    } catch (Exception e) {
        throw new RuntimeException("Error al construir o empujar la imagen Docker: ${e.message}")
    }
}

def dockerLogin(String registryUrl) {
    try {
        // Tu lógica de inicio de sesión con Docker aquí
        // Puedes utilizar bibliotecas como docker-py para esto
        return true
    } catch (Exception e) {
        throw new RuntimeException("Error al iniciar sesión en Docker: ${e.message}")
    }
}
