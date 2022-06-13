(defproject github "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"],
                 [org.springframework.boot/spring-boot-starter-web "2.6.7"],
                 [org.springframework.boot/spring-boot-configuration-processor "2.6.7"]]
  :main com.assembly.github.core
  :aot :all
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
