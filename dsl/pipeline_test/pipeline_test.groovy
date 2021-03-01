folder('pipeline_test') {
  displayName('Pipeline Test')
  description('Folder for the pipeline test example')
}
pipelineJob('pipeline job test') {
  definition {
    cps {
      script(readFileFromWorkspace("dsl/pipeline_test/Jenkinsfile"))
      sandbox()     
    }
  }
}