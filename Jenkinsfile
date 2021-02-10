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
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                // true = set pipeline to UNSTABLE, false = don't
                waitForQualityGate abortPipeline: true
                }
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test --info'
            }
        }
    }
    post {
        always {
            junit(
                    allowEmptyResults: true,
                    testResults: '**/test-reports/*.xml'
                 )
//             mail(
//                     to: 'todd@eidson.info',
//                     subject: "Pipeline complete: ${currentBuild.fullDisplayName}",
//                     body: "Something is wrong with ${env.BUILD_URL}"
//                 )
        }
    }
}