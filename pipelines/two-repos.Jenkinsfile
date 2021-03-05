pipeline {
    agent any
    parameters {
        string(defaultValue: "123", description: 'This is a parameter', name: 'PARAMETER01')
    }
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
                build job: 'hello-jenkins',
                   parameters: [string(name: 'HELLO', value: String.valueOf(PARAMETER01))]
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