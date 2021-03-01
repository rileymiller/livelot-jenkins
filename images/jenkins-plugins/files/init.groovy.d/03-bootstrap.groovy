import javaposse.jobdsl.dsl.DslScriptLoader
import javaposse.jobdsl.plugin.JenkinsJobManagement

def jobDslScript = new File('/usr/share/jenkins/ref/bootstrap/bootstrap.groovy')
def workspace = new File('.')
def jobManagement = new JenkinsJobManagement(System.out, [:], workspace)

println("INFO: Job Management" + jobManagement)

new DslScriptLoader(jobManagement).runScript(jobDslScript.text)

println("INFO: We've read in the bootstrap script" + jobManagement)

