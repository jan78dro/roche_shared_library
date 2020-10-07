package org.com.utils

def maven(String method){
	sh("mvn " + method )
}

def get_image(){
	image = readMavenPom().getArtifactId()
	return image	
}

def get_version(){
	version = readMavenPom().getVersion()
	return version	
}
