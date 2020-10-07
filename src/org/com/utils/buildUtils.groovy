package org.com.utils

def maven(String method){
	sh("mvn " + method )
}

def get_image(){
	image = readMavenPom().getArtifactId()
	return image	
}

def get_version(){
	version = eadMavenPom().getVersion()
	return version	
}
