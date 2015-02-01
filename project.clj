(defproject farn "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2511" :scope "provided"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [ring "1.3.1"]
                 [compojure "1.2.0"]
                 [enlive "1.1.5"]
                 [om "0.7.3"]
                 [figwheel "0.1.4-SNAPSHOT"]
                 [environ "1.0.0"]
                 [com.cemerick/piggieback "0.1.3"]
                 [prismatic/dommy "1.0.0"]
                 [garden "1.1.7"]
                 [hiccup "1.0.5"]
                 [weasel "0.4.0-SNAPSHOT"]
                 [leiningen "2.5.0"]
                 ]

  :main farn.server/dump

  :aliases {
          "dump-index-html" ["run" "-m" "farn.server/dump-html"]
          }

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-environ "1.0.0"]]

  :min-lein-version "2.5.0"

  :uberjar-name "farn.jar"

  :cljsbuild
  {:builds
   {:app
    {:source-paths ["src/cljs"]
     :compiler {:output-to     "resources/public/js/app.js"
                :output-dir    "resources/public/js/"
                :source-map    "resources/public/js/app.js.map"
                :preamble      []
                :externs       []
                :pretty-print  true
                :optimizations :none
                }}
    :release {
              :source-paths ["src/cljs"]
              :compiler
              {
               :output-to "target/release/app.js"

               ;; these two should be off for release
               ;; but are useful in pinpointing problems with
               ;; advanced name munging
               ;:output-dir "target/release/"
               ;:source-map "target/release/app.js.map"

               :optimizations :advanced
               :pretty-print false

               ;; things we want outside google closure compiler
               :externs ["src/js/pixi/extern.js"
                         "src/js/externs/noise.js"
                         "src/js/externs/random.js"
                         "src/js/externs/map.js"

                         ;; http://closureplease.com/externs/
                         "src/js/externs/w3c_audio.js"
                         ]}}}}

  :profiles {:dev {:repl-options {:init-ns farn.server
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

                   :plugins [[lein-figwheel "0.1.4-SNAPSHOT"]]

                   :figwheel {:http-server-root "public"
                              :port 3449
                              :css-dirs ["resources/public/css"]}

                   :env {:is-dev true}

                   :cljsbuild {:builds {:app {:source-paths ["env/dev/cljs"]
                                              :compiler {:optimizations :none
                                                         :pretty-print true
                                                         }
                                              }}}}

             :uberjar {:hooks [leiningen.cljsbuild]
                       :env {:production true}
                       :omit-source true
                       :aot :all
                       :cljsbuild {:builds {:app
                                            {:source-paths ["env/prod/cljs"]
                                             :compiler
                                             {:optimizations :advanced
                                              :pretty-print false}}}}}

             :build-static {:hooks [leiningen.cljsbuild]
                            :env {:production true}
                            :cljsbuild {:builds {:app
                                            {:source-paths ["env/prod/cljs"]
                                             :compiler
                                             {:optimizations :advanced
                                              :pretty-print false}}}}}})
