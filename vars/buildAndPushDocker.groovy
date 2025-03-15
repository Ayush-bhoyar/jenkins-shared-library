def call(String imageName, String dockerCredId) {
    withCredentials([usernamePassword(credentialsId: dockerCredId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh 'docker login -u "$DOCKER_USER" -p "$DOCKER_PASS"'
    }
    sh "docker build -t ${imageName} ."
    sh "docker push ${imageName}"
}
