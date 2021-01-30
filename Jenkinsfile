node() {
    stage('Source') {
        git (
            url: 'git@github.com:eidsonator/hello-jenkins.git',
            credentialsId: 'gitt'
            )
    }
    stage("build & SonarQube analysis") {
          node {
              withSonarQubeEnv('local') {
                 sh '''
                 ./gradlew build
                 ./gradlew sonarqube -Dsonar.projectKey=hello-jenkins \
                                                   -Dsonar.host.url=http://127.0.0.1:9000 \
                                                   -Dsonar.login=71fd8393cd3d65329df888711ef4029aa60e9c06

                 '''
              }
          }
      }

      stage("Quality Gate"){
          timeout(time: 1, unit: 'HOURS') {
              def qg = waitForQualityGate()
              if (qg.status != 'OK') {
                  error "Pipeline aborted due to quality gate failure: ${qg.status}"
              }
          }
      }
    stage('Test') {
        sh './gradlew clean test --info'
    }
}