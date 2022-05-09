def call(tomcatIp,warName,credId){
    sshagent(["${credId}"]) {
        // Copy war file to tomcat server
        sh "scp -o StrictHostKeyChecking=no target/*.war ec2-user@${tomcatIp}:/opt/tomcat8/webapps/${warName}.war"
        // stopt tomcat
        sh "ssh ec2-user@${tomcatIp} /opt/tomcat8/bin/shutdown.sh"
        // start tomcat
        sh "ssh ec2-user@${tomcatIp} /opt/tomcat8/bin/startup.sh"
    }
}
