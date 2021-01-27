node() {
//     stage('Source') {
//         git (
//             url: 'git@github.com:eidsonator/hello-jenkins.git',
//             credentialsId: 'gitt'
//             )
//     }
    stage('Build') {
        sh './gradlew build'
    }
    stage('Test') {
        sh './gradlew clean test --info'
    }
}