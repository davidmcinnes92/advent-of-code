(ns day-2.core
  (:gen-class))

(require '[clojure.string :as str])

(def input (slurp "resources/input.txt"))
(def input-test (slurp "resources/input-test.txt"))
(def lines (str/split-lines input))
(def horizontal-position (atom 0))
(def depth (atom 0))

(defn dive [command units]
  (cond
    (= command "forward") (reset! horizontal-position (+ @horizontal-position units))
    (= command "down") (reset! depth (+ @depth units))
    (= command "up") (reset! depth (- @depth units))))

(defn process-input [input]
  (doseq [x input]
    (def instruction (str/split x #" "))
    (def command (nth instruction 0))
    (def units (Long/parseLong (nth instruction 1)))
    (dive command units)))

(defn position-depth-product []
  (* @horizontal-position @depth))

(defn -main
  [& args]
  (process-input lines)
  (println "The position depth product is:" (position-depth-product)))
