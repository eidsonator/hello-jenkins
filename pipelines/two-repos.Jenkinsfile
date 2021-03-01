pipeline {
    agent any
    stages {
        stage('Source') {
            steps {
                git (
                    url: 'git@github.com:eidsonator/hello-jenkins.git',
                    credentialsId: 'git-ssh'
                    )
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
                    testResults: 'build/test-results/test/*.xml'
                 )
//             mail(
//                     to: 'todd@eidson.info',
//                     subject: "Pipeline complete: ${currentBuild.fullDisplayName}",
//                     body: "Something is wrong with ${env.BUILD_URL}"
//                 )
        }
    }
}