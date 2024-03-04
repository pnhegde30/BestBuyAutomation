pipeline { 
	agent any 
	
	stages { 
		stage('Build') { 
			steps { 
				echo "Build" 
				sh 'mvn clean package -DskipTests'
				archiveArtifacts artifacts: '**/target/*.jar'
			}
		}
		
		stage('Test') { 
			steps { 
				echo "Test" 
				sh 'mvn test -B' 
			} 
		} 
	} 
}