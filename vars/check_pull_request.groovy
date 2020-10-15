import org.com.utils.checkUtils

def call() {
  def checkUtils = new checkUtils()
  
  pipeline {
    agent {
      label 'agent_maven'
    }
    stages {
      stage('validate security code') {
        steps {
          script {
            result_validation = checkUtils.security()
            if(result_validation == true){
              currentBuild.result = 'FAILURE'
            }else if (result_validation == false){
              currentBuild.result = 'FAILURE'
            }
          }
        }
      }
    }
  }
}
