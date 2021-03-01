pipelineJob('pipeline job test') {
  definition {
    cps {
      script(readFileFromWorkspace("dsl/pipeline_test/Jenkinsfile"))
      sandbox()     
    }
  }
}