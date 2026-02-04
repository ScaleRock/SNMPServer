rootProject.name = "SNMPServer"
include("core", "snmpv1", "snmpv2c", "snmpv3")

gradle.rootProject {
    buildCache {
        local {
            isEnabled = true
        }
    }
}
