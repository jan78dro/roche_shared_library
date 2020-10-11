import org.com.utils.checkdUtils

def call() {
  def check_Utils = new checkUtils()
  
  pipeline {
    agent {
      label 'agent_maven'
    }
    stages {
      stage('validate security code') {
        steps {
          script {
            image = build_utils.get_image()
            version = build_utils.get_version()
            result_vaidation = check_Utils.security()
            if(result_validation == true){
              currentBuild.result = 'SUCCESS'
            }else if (result_validation == false){
              currentBuild.result = 'FAILURE'
            }
          }
        }
      }
    }
  }
}
