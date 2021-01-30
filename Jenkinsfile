node() {
    stage('Source') {
        git (
            url: 'git@github.com:eidsonator/hello-jenkins.git',
            credentialsId: 'gitt'
            )
    }
    stage('Build') {
        sh '''
        ./gradlew sonarqube -Dsonar.projectKey=hello-jenkins \
                                          -Dsonar.host.url=http://127.0.0.1:9000 \
                                          -Dsonar.login=71fd8393cd3d65329df888711ef4029aa60e9c06

        '''
        sh './gradlew build'
    }
    stage('Test') {
        sh './gradlew clean test --info'
    }
}