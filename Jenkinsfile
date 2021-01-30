pipeline {
    agent any
    stages {
        stage('Source') {
            steps {
                git (
                    url: 'git@github.com:eidsonator/hello-jenkins.git',
                    credentialsId: 'gitt'
                    )
            }
        }
        stage("build & SonarQube analysis") {
            steps {
                withSonarQubeEnv('local') {
                   sh './gradlew build'
                   sh './gradlew sonarqube -Dsonar.projectKey=hello-jenkins'
                }
            }
        }
        stage("Quality Gate"){
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    def qg = waitForQualityGate()
                    if (qg.status != 'OK') {
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                }
            }
        }
        stage('Test') {
            sh './gradlew clean test --info'
        }
    }
    post {
        always {
            mail to: 'todd@eidson.info',
                 subject: "Pipeline complete: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}