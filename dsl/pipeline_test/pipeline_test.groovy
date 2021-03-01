pipelineJob('pipeline job test') {
  definition {
    cps {
      script(readFileFromWorkspace("jobs/pipeline_test/Jenkinsfile"))
      sandbox()     
    }
  }
}