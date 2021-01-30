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
                 sh './gradlew build'
                 sh './gradlew sonarqube -Dsonar.projectKey=hello-jenkins'
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