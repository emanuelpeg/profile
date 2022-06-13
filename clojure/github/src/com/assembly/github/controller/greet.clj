(ns com.assembly.github.controller.greet
  (:import (org.springframework.web.bind.annotation PathVariable RequestMapping RequestMethod RestController)
           (org.springframework.http ResponseEntity))
  )

(gen-class
  :name ^{RestController {}
          RequestMapping {:value ["/v1/greet"]}} com.assembly.github.controller.greet.GreeterEndPoint
  :methods [[^{RequestMapping {:value ["/hello"]
                               :method [RequestMethod/GET]}} sayHello [] Object ]
            [^{RequestMapping {:value ["/helloto/{name}"]
                               :method [RequestMethod/GET]}} sayHelloTo [^{PathVariable {:value "name"}} String] Object ]
            ]
  :state injected
  :init init
)

(defn -init
  "Initialize the class by setting the state to an empty map, which can be populated with injected dependencies."
  []
  [[] (atom {})])

(defn -sayHello
  [this]
  (ResponseEntity/ok "Hello"))

(defn -sayHelloTo
  [this name]
  (ResponseEntity/ok (str "Hello " name)))