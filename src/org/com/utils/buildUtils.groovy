package src/org/com/utils

/**
 * Function to build with maven
 * @param method  --> clean, install, test, etc
 */

def buildMaven(String method){
		sh("mvn " + method )
}
