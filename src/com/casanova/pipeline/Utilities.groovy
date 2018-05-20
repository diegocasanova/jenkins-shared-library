package com.casanova.pipeline
class Utilities {

	static def mvn(script, buildDir, args) {
		script.sh "mvn -f ${buildDir}/pom.xml ${args}"
	}

	static def npm(script, args) {
		script.sh "npm ${args}"
	}

	static def ng(script, args) {
		script.sh "ng ${args}"
	}
}