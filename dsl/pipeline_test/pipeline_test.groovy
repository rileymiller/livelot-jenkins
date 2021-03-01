folder('pipeline_test') {
  displayName('Pipeline Test')
  description('Folder for the pipeline test example')
}
pipelineJob('pipeline_test/example') {
  definition {
    cps {
      script(readFileFromWorkspace("dsl/pipeline_test/Jenkinsfile"))
      sandbox()     
    }
  }
}