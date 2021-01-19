pipeline {
  agent any
  stages {
    stage('Checking Java') {
      parallel {
        stage('Checking Java') {
          steps {
            bat 'java -version'
          }
        }

        stage('Checking Maven') {
          steps {
            bat 'mvn -v'
          }
        }

      }
    }

    stage('Build Project') {
      steps {
        fileExists 'pom.xml'
      }
    }

    stage('Build Run') {
      steps {
        bat 'mvn clean test'
      }
    }

  }
}