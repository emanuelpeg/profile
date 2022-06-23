(ns com.assembly.github.controller.github
  (:import (org.springframework.http ResponseEntity)
           (org.springframework.web.bind.annotation PathVariable RequestMapping RequestMethod RestController)
           (org.springframework.beans.factory.annotation Autowired))
  )

(gen-class
  :name ^{RestController {}
          RequestMapping {:value ["/v1/github"]}} com.assembly.github.controller.greet.GithubEndPoint
  :methods [[^{RequestMapping {:value  ["/userdata/{username}"]
                               :method [RequestMethod/GET]}} getData [^{PathVariable {:value "username"}} String] Object]
            [^{Autowired {}} setGithubService [com.assembly.github.client.GithubService] void]]
  :state injected
  :init init
  )

(defn -init
  "Initialize the class by setting the state to an empty map, which can be populated with injected dependencies."
  []
  [[] (atom {})])

(defn -setGithubService
  "Setter GithubService"
  [this service]
  (swap! (.injected this) assoc-in [:github-service] service))

(defn -getData
  [this username]
    (ResponseEntity/ok
      (.getUserInfo (:github-service@(.injected this)) username)
      )
  )