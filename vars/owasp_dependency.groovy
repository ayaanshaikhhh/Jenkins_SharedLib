
def call() {
    dependencyCheck(
        odcInstallation: 'OWASP',
        nvdCredentialsId: 'nvd-api-key',
        additionalArguments: '--scan ./ --disableNodeAudit'
    )

    dependencyCheckPublisher(
        pattern: '**/dependency-check-report.xml'
    )
}
