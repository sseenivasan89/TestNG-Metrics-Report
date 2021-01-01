pipeline {
  agent any
  stages {
    stage('Check Tool Version') {
      parallel {
        stage('Check Tool Version') {
          steps {
            sh '''java -version

'''
          }
        }

        stage('Check pom file') {
          steps {
            fileExists 'pom.xml'
          }
        }

      }
    }

    stage('Build Project') {
      steps {
        sh 'mvn clean test'
      }
    }

    stage('Results') {
      steps {
        echo 'Build is success'
      }
    }

  }
}