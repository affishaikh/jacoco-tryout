pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
        stage('Publish Test Coverage Report') {
            when {expression {config.publishUnitTestCoverageReports}}
            steps {
                 step([$class: 'JacocoPublisher',
                       execPattern: '/build/*/jacoco/*.exec',
                       classPattern: '/build/*/classes',
                       sourcePattern: 'src/main/kotlin',
                       exclusionPattern: 'src/*test*',
                 ])
              }
        }
    }
}