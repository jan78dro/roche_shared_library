def call() {

  timestamps {
    pipeline {
      options {
        timeout(time: 10, unit: 'DAYS')
      }
      agent {none}
      stages {
        
        stage('1 - say hello') {
          steps {
            script {
              echo("Hi, how are you today")
            }
          }
        }
        
        stage('2 - say goodbay') {
          steps {
            script {
              echo("good bye, I hope you enjoy")
            }
          }
        }
        
      }
    }
  }
}
