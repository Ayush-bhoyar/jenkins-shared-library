def call(String imageName = 'ayushdocker2607/testapp:latest', String dockerCredId = 'dockerhub-cred') {
    withCredentials([usernamePassword(credentialsId: dockerCredId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh 'docker login -u "$DOCKER_USER" -p "$DOCKER_PASS"'
    }
    sh "docker build -t ${imageName} ."
    sh "docker push ${imageName}"
}

