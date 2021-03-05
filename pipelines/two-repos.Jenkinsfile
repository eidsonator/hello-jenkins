pipeline {
    agent any
    stages {
        stage('Source') {
            steps {
                dir("hello-jenkins") {
                    git (
                        url: 'git@github.com:eidsonator/hello-jenkins.git',
                        credentialsId: 'git-ssh'
                        )
                    sh 'ls -l'
                }
                dir("squashDemo") {
                   git (
                       url: 'git@github.com:eidsonator/SquashDemo.git',
                       credentialsId: 'git-ssh'
                       )
                   sh 'ls -l'
                }
            }
        }
        stage('Test') {
            steps {
                def job = build job: 'hello-jenkins',
                    parameters: [[$class: 'StringParameterValue', name: 'who', value: 'DZone Readers']]
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