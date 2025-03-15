def call(String imageName = 'ayushdocker2607/testapp:latest', String containerName = 'testcontainer', String port = '3000') {
    sh "docker stop ${containerName} || true"
    sh "docker rm ${containerName} || true"
    sh "docker pull ${imageName}"
    sh "docker run -d -p ${port}:${port} --name ${containerName} ${imageName}"
}
