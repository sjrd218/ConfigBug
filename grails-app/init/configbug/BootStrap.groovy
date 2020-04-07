package configbug

import org.grails.config.NavigableMap

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        //Uncomment this for a workaround
        //def toFlatConfig = {
        //    if(delegate.isEmpty()) return [:]
        //    else {
        //        return delegate.parent.toFlatConfig()
        //    }
        //}
        //toFlatConfig.resolveStrategy = Closure.DELEGATE_FIRST
        //NavigableMap.NullSafeNavigator.metaClass.toFlatConfig = toFlatConfig


        def noproblem = grailsApplication.config.keyexists.sothisworks.toFlatConfig()

        println "no problem with toFlatConfig() if key exists"

        def problem = grailsApplication.config.keydoesnotexist?.toFlatConfig()

        println "Fails to boot"
    }
    def destroy = {
    }
}
